package com.foodKing.demoFoodking.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foodKing.demoFoodking.bean.ProductRequest;
import com.foodKing.demoFoodking.entity.Products;

public interface ProductServices {
	
	String createProduct(ProductRequest request);
	List<Products> getAllProducts();
	Products getProductById(Long id);
	  Products updateProduct(Long id, ProductRequest req);
	  void deleteProduct(Long id);
	

}
