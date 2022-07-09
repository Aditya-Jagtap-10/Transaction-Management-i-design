package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.springboot.domain.User;
import com.springboot.repository.UserRepository;

public class UserService implements UserDetailsService {

    @Autowired
	private UserRepository uRepo;	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User u = uRepo.findByUsername(username);
		UserBuilder builder = null;
		if(u!= null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(u.getName());
			builder.password(new BCryptPasswordEncoder().encode(u.getPassword()));
			builder.roles(u.getRole());
			return builder.build();
		}
		throw new UsernameNotFoundException("Invalid User Credentials");
	}

}