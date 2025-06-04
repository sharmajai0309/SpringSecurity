package com.jwt.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.Entity.User;
import com.jwt.Service.IUserService;
import com.jwt.Service.Jwtutil;
import com.jwt.payload.UserRequest;
import com.jwt.payload.UserResponse;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/User")
public class UserRestController {
	
	
	private final IUserService service;
	 private final AuthenticationManager authenticationManager;
	 
	private final Jwtutil util;
	
	 
	 public UserRestController(IUserService service,AuthenticationManager authenticationManager, Jwtutil util) {
    	this.service = service;
		this.authenticationManager = authenticationManager;
		this.util = util;
    }

	@PostMapping("/create")
	public ResponseEntity<String> saveuser(@RequestBody User user) {
		service.saveUser(user);
		return ResponseEntity.ok("User Created"+"with ID :"+ user.getId());
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest userRequest) {
		UsernamePasswordAuthenticationToken vaidation = new UsernamePasswordAuthenticationToken(userRequest.getUsername(),userRequest.getPassword());
		authenticationManager.authenticate(vaidation);
		Date generationdate = new Date();
		// generate token
		String token = util.createToken(userRequest.getUsername());
		
		UserResponse response = new UserResponse(token,"Generated on :"+ generationdate);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/welcome")
    public String welcome() {
        return "Welcome! You've successfully authenticated with JWT";
    }
	
	

}
