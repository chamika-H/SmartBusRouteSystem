package com.example.bus_router_planner.service;

import com.example.bus_router_planner.model.FavoriteRoute;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class FavoriteRouteService {

    private final List<FavoriteRoute> favoriteRoutes = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    // Add favorite
    public FavoriteRoute addFavorite(FavoriteRoute route) {
        route.setId(counter.incrementAndGet());
        favoriteRoutes.add(route);
        return route;
    }

    // Get all favorites
    public List<FavoriteRoute> getAllFavorites() {
        return favoriteRoutes;
    }

    // Delete favorite
    public void deleteFavorite(Long id) {
        favoriteRoutes.removeIf(route -> route.getId().equals(id));
    }
}