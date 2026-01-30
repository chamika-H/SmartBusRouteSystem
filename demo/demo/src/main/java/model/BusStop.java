package model;



import java.util.Objects;

/**
 * Represents a bus stop with geographic coordinates
 */
public class BusStop {
    private String id;
    private String name;
    private double latitude;
    private double longitude;

    // Constructors
    public BusStop() {}

    public BusStop(String id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Backward compatibility constructor
    public BusStop(String name) {
        this.id = name;
        this.name = name;
        this.latitude = 0.0;
        this.longitude = 0.0;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusStop busStop = (BusStop) o;
        return Objects.equals(id, busStop.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
