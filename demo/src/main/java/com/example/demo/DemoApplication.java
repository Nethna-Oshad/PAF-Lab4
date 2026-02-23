package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // Import for Path Variables
import org.springframework.web.bind.annotation.RequestParam; // Import for Query Parameters
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // --- Task 1: Simple Greeting ---
    // Access: http://localhost:8080/greet
    @GetMapping("/greet")
    public String simpleGreet() {
        return "Welcome to Spring Boot!"; 
    }

    // --- Task 2 & Extension: Personalized Greeting with Optional Message ---
    // Access: http://localhost:8080/greet/John
    // Access: http://localhost:8080/greet/John?message=Good%20to%20see%20you!
    @GetMapping("/greet/{username}")
    public String dynamicGreet(
            @PathVariable("username") String username, 
            @RequestParam(value = "message", defaultValue = "Welcome to Spring Boot!") String message) {
        
        // This combines the name from the URL path and the message from the query param
        return "Hello " + username + "! " + message;
    }
}