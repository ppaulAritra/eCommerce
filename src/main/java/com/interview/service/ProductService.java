package com.interview.service;

import java.util.List;

import com.interview.model.Product;

public interface ProductService {

	void save(Product product);

	List<Product> findAll();

	Product findById(Long id);

	void deleteProduct(Long id);

	List<Product> getMostProfitableProduct();


}
