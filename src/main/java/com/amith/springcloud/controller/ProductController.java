package com.amith.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amith.springcloud.model.Product;
import com.amith.springcloud.repos.ProductRepository;

@RestController
@RequestMapping("/productapi")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping(value = "/products")
	public Product create(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
}
