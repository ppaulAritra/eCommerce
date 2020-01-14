package com.interview.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.model.Product;
import com.interview.repository.ProductRepository;
import com.interview.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	


	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
        double profit = product.getPrice() - product.getOurPrice();
		double profitPercent = (profit / product.getOurPrice())*100;
		product.setProfitPercentage(profitPercent);
		productRepository.save(product);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		
	}

	@Override
	public List<Product> getMostProfitableProduct() {
		// TODO Auto-generated method stub
		return productRepository.findTop5ByOrderByProfitPercentageDesc();
	}


	
	

}
