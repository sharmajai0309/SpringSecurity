package com.jwt.payload;

import lombok.Data;

@Data
public class UserRequest {
	
	private String username;
	private String password;
}
