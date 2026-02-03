package com.example.bus_router_planner.algorithms;

import com.example.bus_router_planner.graph.Graph;
import com.example.bus_router_planner.model.*;
import java.util.*;

public class AStar {

    public static RouteResponse getRoute(Graph graph, BusStop source,
                                         BusStop destination, String mode) {

        Map<BusStop, Double> gScore = new HashMap<>();
        Map<BusStop, Double> fScore = new HashMap<>();
        Map<BusStop, BusStop> prev = new HashMap<>();

        PriorityQueue<BusStop> openSet = new PriorityQueue<>(
                Comparator.comparingDouble(stop -> fScore.getOrDefault(stop, Double.POSITIVE_INFINITY))
        );

        Set<BusStop> closedSet = new HashSet<>();

        for (BusStop stop : graph.getAllStops()) {
            gScore.put(stop, Double.POSITIVE_INFINITY);
            fScore.put(stop, Double.POSITIVE_INFINITY);
        }

        gScore.put(source, 0.0);
        fScore.put(source, heuristic(source, destination));

        openSet.add(source);
        prev.put(source, null);

        while (!openSet.isEmpty()) {
            BusStop current = openSet.poll();

            if (current.equals(destination)) {
                return reconstructPath(prev, gScore, source, destination, mode);
            }

            closedSet.add(current);

            for (Edge edge : graph.getEdges(current)) {
                BusStop neighbor = edge.getDestination();

                if (closedSet.contains(neighbor)) continue;

                double tentativeG = gScore.get(current) + getWeight(edge, mode);

                if (tentativeG < gScore.get(neighbor)) {
                    prev.put(neighbor, current);
                    gScore.put(neighbor, tentativeG);
                    fScore.put(neighbor, tentativeG + heuristic(neighbor, destination));

                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }

        return new RouteResponse(false, new ArrayList<>(), 0, "A*", mode);
    }

    private static double heuristic(BusStop from, BusStop to) {
        double lat1 = Math.toRadians(from.getLatitude());
        double lat2 = Math.toRadians(to.getLatitude());
        double lon1 = Math.toRadians(from.getLongitude());
        double lon2 = Math.toRadians(to.getLongitude());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon/2) * Math.sin(dLon/2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        double R = 6371.0;

        return R * c;
    }

    private static double getWeight(Edge edge, String mode) {
        return switch (mode) {
            case "time" -> edge.getTime();
            case "cost" -> edge.getCost();
            default -> edge.getDistance();
        };
    }

    private static RouteResponse reconstructPath(Map<BusStop, BusStop> prev,
                                                 Map<BusStop, Double> gScore,
                                                 BusStop source, BusStop dest,
                                                 String mode) {
        List<BusStop> path = new ArrayList<>();
        BusStop current = dest;

        while (current != null) {
            path.add(0, current);
            current = prev.get(current);
        }

        if (path.isEmpty() || !path.get(0).equals(source)) {
            return new RouteResponse(false, new ArrayList<>(), 0, "A*", mode);
        }

        int totalCost = gScore.get(dest).intValue();
        return new RouteResponse(true, path, totalCost, "A*", mode);
    }
}