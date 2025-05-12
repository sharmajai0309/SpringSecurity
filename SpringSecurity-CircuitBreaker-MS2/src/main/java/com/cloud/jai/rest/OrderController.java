package com.cloud.jai.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OrderController {
	
	@GetMapping("/item")
	public ResponseEntity<String> getMethodName() {
		
		return ResponseEntity.ok("Order Placed");
		
	}
	
	

}
