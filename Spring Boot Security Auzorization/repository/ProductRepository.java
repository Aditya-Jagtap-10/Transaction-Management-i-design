package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	//Fill the Code
	List<Product> findByIsAvailable(Boolean isAvailable);

}