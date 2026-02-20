package com.example.bus_router_planner.model;

public class FavoriteRoute {

    private Long id;
    private String source;
    private String destination;
    private String algorithm;

    public FavoriteRoute() {
    }

    public FavoriteRoute(Long id, String source, String destination, String algorithm) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.algorithm = algorithm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}