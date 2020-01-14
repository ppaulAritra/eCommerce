package com.interview.restservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.model.Product;
import com.interview.repository.ProductRepository;

@RestController
@RequestMapping("/productapi")
public class ProductRestController { 
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/productList")
	public List<Product> getProductList(){
		return (List<Product>) productRepository.findAll();
		
		
	}
}
