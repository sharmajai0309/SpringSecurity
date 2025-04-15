package com.cloud.jai.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	
}
