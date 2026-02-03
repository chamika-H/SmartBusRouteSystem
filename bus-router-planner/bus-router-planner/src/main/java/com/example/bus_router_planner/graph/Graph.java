package com.example.bus_router_planner.graph;

import com.example.bus_router_planner.model.BusStop;
import com.example.bus_router_planner.model.Edge;
import java.util.*;

public class Graph {
    public Map<BusStop, List<Edge>> adjList = new HashMap<>();

    public void addStop(BusStop stop) {
        adjList.putIfAbsent(stop, new ArrayList<>());
    }

    public void addRoute(BusStop from, BusStop to, int distance,
                         int time, int cost, boolean safe) {
        adjList.get(from).add(new Edge(to, distance, time, cost, safe));
    }

    public void addBidirectionalRoute(BusStop stop1, BusStop stop2,
                                      int distance, int time, int cost, boolean safe) {
        addRoute(stop1, stop2, distance, time, cost, safe);
        addRoute(stop2, stop1, distance, time, cost, safe);
    }

    public Set<BusStop> getAllStops() {
        return adjList.keySet();
    }

    public BusStop findStopById(String id) {
        return adjList.keySet().stream()
                .filter(stop -> stop.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Edge> getEdges(BusStop stop) {
        return adjList.getOrDefault(stop, new ArrayList<>());
    }

    public void printGraph() {
        System.out.println("=== Graph Structure ===");
        for (Map.Entry<BusStop, List<Edge>> entry : adjList.entrySet()) {
            String nodeId = entry.getKey().getId();
            List<Edge> edges = entry.getValue();
            System.out.print(nodeId + ": ");
            for (Edge edge : edges) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }
}