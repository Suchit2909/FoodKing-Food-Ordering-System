package com.foodKing.demoFoodking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodKing.demoFoodking.bean.ProductRequest;
import com.foodKing.demoFoodking.entity.Products;
import com.foodKing.demoFoodking.services.ProductServices;

@RestController
@RequestMapping("/api/admin/product")
@CrossOrigin("http://localhost:3000")
public class ProductController {
	
	  @Autowired
	    private ProductServices productService;

	    @PostMapping("/create")
	    public ResponseEntity<String> createProduct(@RequestBody ProductRequest request) {
	        return ResponseEntity.ok(productService.createProduct(request));
	    }

	    @GetMapping("/get")
	    public ResponseEntity<List<Products>> getAllProducts() {
	        return ResponseEntity.ok(productService.getAllProducts());
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductRequest request) {
	        productService.updateProduct(id, request);
	        return ResponseEntity.ok("✅ Product updated successfully");
	    }
	    
	    @GetMapping("/get/{id}")
	    public ResponseEntity<Products> getProductById(@PathVariable long id){
	    	Products product= productService.getProductById(id);
	    	return ResponseEntity.ok(product);
	    	
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
	        productService.deleteProduct(id);
	        return ResponseEntity.ok("✅ Product deleted successfully");
	    }

}
