package com.example.bus_router_planner.controller;

import com.example.bus_router_planner.model.FavoriteRoute;
import com.example.bus_router_planner.service.FavoriteRouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin
public class FavoriteRouteController {

    private final FavoriteRouteService favoriteRouteService;

    public FavoriteRouteController(FavoriteRouteService favoriteRouteService) {
        this.favoriteRouteService = favoriteRouteService;
    }

    // Save favorite route
    @PostMapping
    public ResponseEntity<FavoriteRoute> saveFavorite(@RequestBody FavoriteRoute route) {
        FavoriteRoute saved = favoriteRouteService.addFavorite(route);
        return ResponseEntity.ok(saved);
    }

    // Get all favorites
    @GetMapping
    public ResponseEntity<List<FavoriteRoute>> getFavorites() {
        return ResponseEntity.ok(favoriteRouteService.getAllFavorites());
    }

    // Delete favorite
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFavorite(@PathVariable Long id) {
        favoriteRouteService.deleteFavorite(id);
        return ResponseEntity.ok("Favorite deleted successfully");
    }
}