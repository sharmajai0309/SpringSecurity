package com.cloud.jai.Service;

import java.util.Optional;

import com.cloud.jai.entity.User;

public interface UserService  {
    
	
	public Integer saveUSer(User user);
	
	Optional<User> getOneUSer(Integer id);
}
