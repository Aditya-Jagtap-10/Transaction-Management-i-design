package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import com.springboot.domain.Product;
import com.springboot.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductRepository repo;

	@GetMapping("/viewAll")
	public List<Product> list() {
		ArrayList<Product> al = new ArrayList<>();
		Iterable<Product> products = repo.findAll();
		for (Product p : products)
			al.add(p);
		return al;
	}

	@GetMapping("/list")
	List<Product> listAvailableProduct() {
		return repo.findByIsAvailable(true);
	}
}