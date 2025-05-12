package com.security.jwtAuth.controller;

import com.security.jwtAuth.Entity.User;
import com.security.jwtAuth.Jwt.JwtUtil;

import com.security.jwtAuth.Payload.UserRequest;
import com.security.jwtAuth.Payload.UserResponse;
import com.security.jwtAuth.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;

@RestController
@RequestMapping("/v1/api/User")
public class UserController {
    @Autowired
    private JwtUtil jwtutil;


    @Autowired
    private IUserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
   @PostMapping("/signup")
        public ResponseEntity<String>Signup(@RequestBody User user){
       String body = userService.saveUser(user);
       return ResponseEntity.ok(body);
   }


        @GetMapping ("/msg")
        public String msg(){
       return "Hello";
        }

        @PostMapping("/login")
        public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest userRequest){

            // validate the user by using Authentication manager
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUsername(),userRequest.getUsername()));
            String token = jwtutil.createToken(userRequest.getUsername(), new HashMap<>());
            System.out.println("Token Information :" + token);


            return ResponseEntity.ok(new UserResponse(token,"User token generated"));
        }
        @PostMapping("/welcome")
       public ResponseEntity<String> showUserData(Principal p){
       System.out.println(p.getClass().getName());
       return ResponseEntity.ok("Hello:" + p.getName());
        }

}
