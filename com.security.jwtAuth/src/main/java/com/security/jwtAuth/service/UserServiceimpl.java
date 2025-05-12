package com.security.jwtAuth.service;

import ch.qos.logback.classic.spi.IThrowableProxy;
import com.security.jwtAuth.Entity.User;
import com.security.jwtAuth.Payload.UserResponse;
import com.security.jwtAuth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceimpl implements IUserService, UserDetailsService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository repo;
    @Override
    public String saveUser(User user) {

        Optional<User> ifUserPresent = repo.findByUsername(user.getUsername());

        if (ifUserPresent.isPresent()){
            return "user name is already present try to login";
        }
        else{
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            repo.save(user);
            return "User saved";
        }
    }

    @Override
    public User findByUsername(String username) {
        Optional<User> byUsername = repo.findByUsername(username);
        if (byUsername.isPresent()){
            return byUsername.get();
        }
        throw new UsernameNotFoundException(username + "Not Exist try to Register");

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        List<GrantedAuthority>list= user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(username,user.getPassword(),list);
    }



}
