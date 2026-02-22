package com.example.bus_router_planner.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RatingService {

    // In-memory store: busNumber -> list of ratings
    private final Map<String, List<Map<String, Object>>> ratings = new ConcurrentHashMap<>();
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public RatingService() {
        // Seed some sample ratings
        addRating("100", 4, 5, 4, "Clean bus, good driver");
        addRating("100", 3, 4, 3, "Bit crowded but on time");
        addRating("138", 5, 5, 5, "Excellent service!");
        addRating("138", 4, 3, 4, "Good overall");
        addRating("183", 3, 4, 3, "Average condition");
        addRating("224", 4, 4, 5, "Very punctual");
        addRating("255", 2, 3, 2, "Bus was late and dirty");
        addRating("400", 5, 5, 4, "Express service, fast");
        addRating("192", 3, 3, 3, "Normal service");
        addRating("1", 4, 4, 4, "Long route but comfortable");
    }
    /**
     * Add a new rating
     */
    public Map<String, Object> addRating(String busNumber, int cleanliness, int driver, int punctuality, String comment) {
        Map<String, Object> rating = new LinkedHashMap<>();
        rating.put("busNumber", busNumber);
        rating.put("cleanliness", Math.min(5, Math.max(1, cleanliness)));
        rating.put("driver", Math.min(5, Math.max(1, driver)));
        rating.put("punctuality", Math.min(5, Math.max(1, punctuality)));
        rating.put("overall", Math.round((cleanliness + driver + punctuality) / 3.0 * 10) / 10.0);
        rating.put("comment", comment);
        rating.put("timestamp", LocalDateTime.now().format(FMT));

        ratings.computeIfAbsent(busNumber, k -> new ArrayList<>()).add(rating);
        return rating;
    }
}
