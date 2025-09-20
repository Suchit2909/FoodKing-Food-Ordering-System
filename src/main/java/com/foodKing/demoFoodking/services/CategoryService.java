package com.foodKing.demoFoodking.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foodKing.demoFoodking.bean.CategoryRequest;
import com.foodKing.demoFoodking.entity.Category;


public interface CategoryService {
	
	String createCategory(CategoryRequest request);
	List<Category> getallCategories();
	Category getCategoryById(Long categoryId);
	String updateCategory(Long id, CategoryRequest request);
	

}
