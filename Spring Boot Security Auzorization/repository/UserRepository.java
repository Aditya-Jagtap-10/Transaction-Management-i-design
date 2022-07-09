package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	//Fill the Code
	User findByUsername(String username);
	
}