package com.example.bus_router_planner.model;

/**
 * Represents one leg/segment of a transit journey.
 * Type can be: "walk", "bus"
 */
public class TransitSegment {

    private String type;           // "walk" or "bus"
    private String busNumber;      // e.g. "138", "224" (null for walk)
    private String fromStop;       // stop name
    private String fromStopId;     // stop ID
    private String toStop;         // stop name
    private String toStopId;       // stop ID
    private int durationMinutes;   // duration of this segment
    private int distanceKm;        // distance
    private int costRs;            // cost in Rs (0 for walking)
    private double fromLat;
    private double fromLng;
    private double toLat;
    private double toLng;
    private int stopCount;         // number of bus stops in this segment

    public TransitSegment() {}

    // ---- Walk segment factory ----
    public static TransitSegment walk(String from, String fromId, String to, String toId,
                                      int minutes, double fromLat, double fromLng,
                                      double toLat, double toLng) {
        TransitSegment seg = new TransitSegment();
        seg.type = "walk";
        seg.fromStop = from;
        seg.fromStopId = fromId;
        seg.toStop = to;
        seg.toStopId = toId;
        seg.durationMinutes = minutes;
        seg.fromLat = fromLat;
        seg.fromLng = fromLng;
        seg.toLat = toLat;
        seg.toLng = toLng;
        seg.costRs = 0;
        seg.stopCount = 0;
        return seg;
    }

    // ---- Bus segment factory ----
    public static TransitSegment bus(String busNumber, String from, String fromId,
                                     String to, String toId, int minutes, int distance,
                                     int cost, int stopCount,
                                     double fromLat, double fromLng,
                                     double toLat, double toLng) {
        TransitSegment seg = new TransitSegment();
        seg.type = "bus";
        seg.busNumber = busNumber;
        seg.fromStop = from;
        seg.fromStopId = fromId;
        seg.toStop = to;
        seg.toStopId = toId;
        seg.durationMinutes = minutes;
        seg.distanceKm = distance;
        seg.costRs = cost;
        seg.fromLat = fromLat;
        seg.fromLng = fromLng;
        seg.toLat = toLat;
        seg.toLng = toLng;
        seg.stopCount = stopCount;
        return seg;
    }

    // ---- Getters & Setters ----

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getBusNumber() { return busNumber; }
    public void setBusNumber(String busNumber) { this.busNumber = busNumber; }

    public String getFromStop() { return fromStop; }
    public void setFromStop(String fromStop) { this.fromStop = fromStop; }

    public String getFromStopId() { return fromStopId; }
    public void setFromStopId(String fromStopId) { this.fromStopId = fromStopId; }

    public String getToStop() { return toStop; }
    public void setToStop(String toStop) { this.toStop = toStop; }

    public String getToStopId() { return toStopId; }
    public void setToStopId(String toStopId) { this.toStopId = toStopId; }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }

    public int getDistanceKm() { return distanceKm; }
    public void setDistanceKm(int distanceKm) { this.distanceKm = distanceKm; }

    public int getCostRs() { return costRs; }
    public void setCostRs(int costRs) { this.costRs = costRs; }

    public double getFromLat() { return fromLat; }
    public void setFromLat(double fromLat) { this.fromLat = fromLat; }

    public double getFromLng() { return fromLng; }
    public void setFromLng(double fromLng) { this.fromLng = fromLng; }

    public double getToLat() { return toLat; }
    public void setToLat(double toLat) { this.toLat = toLat; }

    public double getToLng() { return toLng; }
    public void setToLng(double toLng) { this.toLng = toLng; }

    public int getStopCount() { return stopCount; }
    public void setStopCount(int stopCount) { this.stopCount = stopCount; }
}