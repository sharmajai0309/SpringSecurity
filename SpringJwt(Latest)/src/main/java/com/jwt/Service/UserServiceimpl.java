package com.jwt.Service;

import java.util.List;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.Entity.User;
import com.jwt.Repository.IUserRepository;

import lombok.AllArgsConstructor;
import lombok.Data;


@Service
public class UserServiceimpl implements IUserService,UserDetailsService{
	
	private final IUserRepository repo;
	private final BCryptPasswordEncoder encoder;
	
	
	//constructor
	public UserServiceimpl(IUserRepository repo,BCryptPasswordEncoder encoder) {
		this.repo = repo;
		this.encoder = encoder;
		
	}
	


	@Override
	public User saveUser(User user) {
		String encodedPassword = encoder.encode(user.getPassword());
	    user.setPassword(encodedPassword); // Set the encoded password
	    return repo.save(user);
	}



	@Override
	public User findByUsername(String username) {
		
		Optional<User> user = repo.findByUsername(username);
		if(user.isPresent()) return user.get();
		
		return null;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByUsername(username);
		if(user == null) throw new UsernameNotFoundException(username + "Not exist");
		
		List<SimpleGrantedAuthority> list = user.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role))
				.collect(Collectors.toList());
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), list);
	}

	

}
