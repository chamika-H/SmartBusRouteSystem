package com.example.bus_router_planner.model;

public class Edge {
    private BusStop destination;
    private int distance;
    private int time;
    private int cost;
    private boolean safe;

    public Edge() {}

    public Edge(BusStop destination, int distance, int time, int cost, boolean safe) {
        this.destination = destination;
        this.distance = distance;
        this.time = time;
        this.cost = cost;
        this.safe = safe;
    }

    public BusStop getDestination() {
        return destination;
    }

    public void setDestination(BusStop destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    @Override
    public String toString() {
        return "→ " + destination.getName() + " (" + distance + "km, " +
                time + "min, Rs." + cost + ")";
    }
}