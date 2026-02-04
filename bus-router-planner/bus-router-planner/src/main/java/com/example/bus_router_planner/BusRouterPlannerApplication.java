package com.example.bus_router_planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BusRouterPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusRouterPlannerApplication.class, args);

		System.out.println("""
                
                ╔═══════════════════════════════════════════════╗
                ║   🚌 Bus Route Planner API Started! 🚌      ║
                ║                                               ║
                ║   Server: http://localhost:8080              ║
                ║                                               ║
                ║   Endpoints:                                  ║
                ║   • GET  /api/health                         ║
                ║   • GET  /api/stops                          ║
                ║   • POST /api/route                          ║
                ║   • GET  /api/routes/alternatives            ║
                ║   • GET  /api/routes/astar                   ║
                ║   • GET  /api/routes/balanced                ║
                ║                                               ║
                ║   Algorithms: Dijkstra, BFS, A*, Balanced    ║
                ╚═══════════════════════════════════════════════╝
                """);
	}
}