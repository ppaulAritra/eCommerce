package com.interview.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.interview.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
	List<Product> findTop5ByOrderByProfitPercentageDesc();

     
	

}
