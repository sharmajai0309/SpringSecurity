package com.cloud.jai.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

	
	@GetMapping({"/Home","/"})
	public String ShowHome() {
		return "Home";
	}
	
	@GetMapping("/Hello")
	public String ShowHello() {
		return "Hello";
	}
	
	@GetMapping("/login")
	public String ShowLogin() {
		return "login";
	}
	
	//only after login
	@GetMapping("/admin")
	public String ShowAdmin() {
		return "admin";
	}
	
	@GetMapping("/customer")
	public String showCustomer() {
		return "customer";
	}
	
	
	
	
}
