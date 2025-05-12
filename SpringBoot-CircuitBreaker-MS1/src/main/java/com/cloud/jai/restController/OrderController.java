package com.cloud.jai.restController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("v1/api/order")
public class OrderController {

    public static final String ORDER_SERVICE = "orderService";

   
    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/menu")
    @CircuitBreaker(name = ORDER_SERVICE, fallbackMethod = "fallbackMethod")
    public ResponseEntity<String> getMenu() {
        try {
            String response = restTemplate.getForObject("http://localhost:8081/item", String.class);
            return ResponseEntity.ok(response);
        } catch (ResourceAccessException ex) {
            // IMPORTANT: Throw RuntimeException to trigger fallback
            throw new RuntimeException("Service is down", ex);
        }
    }

    public ResponseEntity<String> fallbackMethod(Throwable throwable) {
        return ResponseEntity.ok("Fallback response: Service is currently unavailable. Please try again later.");
    }

   
}
