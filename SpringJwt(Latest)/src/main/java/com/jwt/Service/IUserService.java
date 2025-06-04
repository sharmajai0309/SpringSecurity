package com.jwt.Service;

import org.springframework.security.core.userdetails.UserDetails;

import com.jwt.Entity.User;

import lombok.Data;


public interface IUserService  {
	

	
	public User saveUser(User user);
	
	
	public User findByUsername(String username);
}
