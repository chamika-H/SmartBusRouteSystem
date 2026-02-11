package com.example.bus_router_planner.controller;

import com.example.bus_router_planner.model.BusStop;
import com.example.bus_router_planner.model.RouteRequest;
import com.example.bus_router_planner.model.RouteResponse;
import com.example.bus_router_planner.model.TransitOption;
import com.example.bus_router_planner.service.RouteService;
import com.example.bus_router_planner.service.TransitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RouteController {

    private final RouteService routeService;
    private final TransitService transitService;

    public RouteController(RouteService routeService, TransitService transitService) {
        this.routeService = routeService;
        this.transitService = transitService;
    }

    @GetMapping("/health")
    public String health() {
        return "Bus Route Planner API is running! 🚌";
    }

    @GetMapping("/stops")
    public List<BusStop> getAllStops() {
        return routeService.getAllBusStops();
    }

    @GetMapping("/stops/search")
    public List<BusStop> searchStops(@RequestParam(defaultValue = "") String q) {
        return routeService.searchStops(q);
    }

    /**
     * 🆕 Google Maps-style transit options.
     * Returns multiple route options with bus numbers, walk segments, times, costs.
     * Example: /api/transit?source=NUG&destination=FORT
     */
    @GetMapping("/transit")
    public List<TransitOption> getTransitOptions(
            @RequestParam String source,
            @RequestParam String destination) {
        return transitService.findTransitOptions(source, destination);
    }

    @PostMapping("/route")
    public RouteResponse findRoute(@RequestBody RouteRequest request) {
        return routeService.findRoute(request);
    }

    @GetMapping("/route")
    public RouteResponse findRouteSimple(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam(defaultValue = "dijkstra") String algorithm,
            @RequestParam(defaultValue = "distance") String mode,
            @RequestParam(defaultValue = "false") boolean emergencyOnly) {

        RouteRequest request = new RouteRequest(source, destination, algorithm, mode, emergencyOnly);
        return routeService.findRoute(request);
    }

    @GetMapping("/routes/alternatives")
    public List<RouteResponse> getAlternativeRoutes(
            @RequestParam String source,
            @RequestParam String destination) {
        return routeService.getAlternativeRoutes(source, destination);
    }

    @GetMapping("/routes/astar")
    public RouteResponse getAStarRoute(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam(defaultValue = "distance") String mode) {

        RouteRequest request = new RouteRequest();
        request.setSource(source);
        request.setDestination(destination);
        request.setAlgorithm("astar");
        request.setMode(mode);
        return routeService.findRoute(request);
    }

    @GetMapping("/routes/balanced")
    public RouteResponse getBalancedRoute(
            @RequestParam String source,
            @RequestParam String destination) {

        RouteRequest request = new RouteRequest();
        request.setSource(source);
        request.setDestination(destination);
        request.setAlgorithm("balanced");
        return routeService.findRoute(request);
    }
}