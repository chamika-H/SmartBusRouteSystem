package model;



/**
 * Request object for finding routes
 * Sent from frontend as JSON
 */
public class RouteRequest {
    private String source;           // Source bus stop ID
    private String destination;      // Destination bus stop ID
    private String algorithm;        // "dijkstra" or "bfs"
    private String mode;            // "distance", "time", or "cost"
    private boolean emergencyOnly;  // Use only safe routes

    // Constructors
    public RouteRequest() {}

    public RouteRequest(String source, String destination, String algorithm,
                        String mode, boolean emergencyOnly) {
        this.source = source;
        this.destination = destination;
        this.algorithm = algorithm;
        this.mode = mode;
        this.emergencyOnly = emergencyOnly;
    }

    // Getters and Setters
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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isEmergencyOnly() {
        return emergencyOnly;
    }

    public void setEmergencyOnly(boolean emergencyOnly) {
        this.emergencyOnly = emergencyOnly;
    }
}