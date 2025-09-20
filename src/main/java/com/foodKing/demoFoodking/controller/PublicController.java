package com.foodKing.demoFoodking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodKing.demoFoodking.entity.Category;
import com.foodKing.demoFoodking.entity.Products;
import com.foodKing.demoFoodking.services.CategoryService;
import com.foodKing.demoFoodking.services.ProductServices;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:3000")
public class PublicController {
	
	@Autowired
	private ProductServices productServices;
	
	@Autowired
    private CategoryService categoryService;

	
	 @GetMapping("/all")
	    public ResponseEntity<List<Products>> getAllProducts() {
	        return ResponseEntity.ok(productServices.getAllProducts());
	    }
	
	
	 @GetMapping("/{id}")
	 public ResponseEntity<Products> getProductById(@PathVariable Long id) {
	     Products product = productServices.getProductById(id);
	     return ResponseEntity.ok(product);
	 }
	 
	 @GetMapping("/category")
	    public ResponseEntity<List<Category>> getAll() {
	        return ResponseEntity.ok(categoryService.getallCategories());
	    }
	 
	@GetMapping("categories/{categoryId}")
	 public ResponseEntity<Category> getCategoryById(@PathVariable Long categoryId){
		 Category category = categoryService.getCategoryById(categoryId);
		 return ResponseEntity.ok(category);
	 }
}
