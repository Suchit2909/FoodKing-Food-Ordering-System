package com.foodKing.demoFoodking.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodKing.demoFoodking.bean.ProductRequest;
import com.foodKing.demoFoodking.entity.Category;
import com.foodKing.demoFoodking.entity.Products;
import com.foodKing.demoFoodking.repository.CategoryRepository;
import com.foodKing.demoFoodking.repository.ProductRepository;
import com.foodKing.demoFoodking.services.ProductServices;

@Service
public class ProductServiceImpl implements ProductServices {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public String createProduct(ProductRequest request) {
		
		Optional<Category> categoryOpt = categoryRepo.findById(request.getCategoryId());
		if(categoryOpt.isEmpty()) {
			throw new RuntimeException("❌ Category not found with ID: " + request.getCategoryId());
		}
		
		Products product = new Products();
		product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setImageUrl(request.getImageUrl());
        product.setMoreDetails(request.getMoreDetails());
        product.setAvailable(request.isAvailable());
        product.setCategory(categoryOpt.get());

        productRepo.save(product);
        return "✅ Product created successfully!";
		
		
	}

	@Override
	public List<Products> getAllProducts() {
		
		        return productRepo.findAll();
	}

	@Override
	public Products updateProduct(Long id, ProductRequest req) {
		 Optional<Category> categoryOpt = categoryRepo.findById(req.getCategoryId());
	        if (categoryOpt.isEmpty()) {
	            throw new RuntimeException("❌ Category not found with ID: " + req.getCategoryId());
	        }

		return productRepo.findById(id)
				.map(existingProduct ->{
					existingProduct.setName(req.getName());
					existingProduct.setDescription(req.getDescription());
                    existingProduct.setPrice(req.getPrice());
                    existingProduct.setImageUrl(req.getImageUrl());
                    existingProduct.setMoreDetails(req.getMoreDetails());
                    existingProduct.setAvailable(req.isAvailable());
                    existingProduct.setCategory(categoryOpt.get());

                    return productRepo.save(existingProduct);
				})
				.orElseThrow(() -> new RuntimeException("❌ Product not found with ID: " + id));
	}

	@Override
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);

	}

	@Override
	public Products getProductById(Long id) {
		   return productRepo.findById(id)
		            .orElseThrow(() -> new RuntimeException("❌ Product not found with ID: " + id));
	}

}
