package com.cloud.jai.Controller;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.jai.Service.UserService;
import com.cloud.jai.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	public UserService service;
	
	
	@GetMapping("/register")
	public String showreg() {
		return "register";
	}
	
	
	
	
	/*
	 * METHOD    : POST
	 * PATH      : /save
	 * INPUT     : User(ModelAttribute)
	 * OUTPUT    : String
	 */

	
	@PostMapping("/save")
	@ResponseBody
	public String saveUser(@ModelAttribute User user) {
	    logger.info("User in Controller");
	    Integer id = service.saveUSer(user);
	    String message = "User registered with ID: " + id;
	    return message;
	}

}
