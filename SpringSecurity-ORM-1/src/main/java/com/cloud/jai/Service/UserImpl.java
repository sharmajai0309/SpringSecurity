package com.cloud.jai.Service;

import java.util.List;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloud.jai.Repository.UserRepository;
import com.cloud.jai.entity.User;
 
@Service
public class UserImpl implements UserService,UserDetailsService{
	
	
private static final Logger logger = LoggerFactory.getLogger(UserImpl.class);
	
   @Autowired
   private BCryptPasswordEncoder encoder;



	@Autowired
	private UserRepository repo;
	
	
	public String incryptshow(int n) {
	    return "*".repeat(n); // Java 11+ feature
	}

	
	@Override
	public Integer saveUSer(User user)  {
		
		int n = user.getUserPwd().length();
		
		
		try {
			logger.info("User Recived");
			logger.info("Processing");
			Thread.sleep(2000);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 logger.info("Name :"+ user.getUserName() + "Email :" + user.getUserName()+"With PassWord :" + incryptshow(n) +"With Role :" +user.getUserRoles());
		 
//		 encrypting the passWord 
		 String encoded = encoder.encode(user.getUserPwd());
		 user.setUserPwd(encoded);
		 
		 repo.save(user);
		 
		 return user.getUserid();
	}


	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		
		Optional<User> optional = repo.findUserByEmail(userEmail);
		if(optional.isPresent()) {
			
			//User object is available
			User user = optional.get();
			List<SimpleGrantedAuthority> authorities = user.getUserRoles().stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
			
//			converting User object into security object for authentication
			return new org.springframework.security.core.userdetails.User(
					userEmail,
					user.getUserPwd(),
					authorities
					);
			
			
			
		}
		else {
			throw new UsernameNotFoundException(userEmail+"Email Not Found");
		}
		
		
		
		
	}


	@Override
	public Optional<User> getOneUSer(Integer id) {
		return repo.findById(id);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
