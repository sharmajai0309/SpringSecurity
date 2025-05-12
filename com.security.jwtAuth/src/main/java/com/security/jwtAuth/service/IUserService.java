package com.security.jwtAuth.service;

import com.security.jwtAuth.Entity.User;
import com.security.jwtAuth.Payload.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {


    public String saveUser(User user);  //save to database

    public User findByUsername(String username);  // check for username in database


}
