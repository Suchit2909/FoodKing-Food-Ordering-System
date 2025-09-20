package com.foodKing.demoFoodking.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodKing.demoFoodking.bean.CategoryRequest;
import com.foodKing.demoFoodking.entity.Category;
import com.foodKing.demoFoodking.repository.CategoryRepository;
import com.foodKing.demoFoodking.services.CategoryService;

@Service
public class CatrgorySeviceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	

	@Override
	public String createCategory(CategoryRequest request) {
		Category category = new Category();
		category.setName(request.getName());
		category.setImageUrl(request.getImageUrl());
		categoryRepo.save(category);
		
		return "✅ Category created successfully!";
	}

	@Override
	public List<Category> getallCategories() {
		return categoryRepo.findAll();
	}

	@Override
	public String updateCategory(Long id, CategoryRequest request) {
		Category category = categoryRepo.findById(id)
		        .orElseThrow(() -> new RuntimeException("❌ Category not found with ID: " + id));

		    category.setName(request.getName());
		    category.setImageUrl(request.getImageUrl());

		    categoryRepo.save(category);

		    return "✅ Category updated successfully!";
	}

	@Override
	public Category getCategoryById(Long categoryId) {
		// TODO Auto-generated method stub
		return categoryRepo.findById(categoryId)
				.orElseThrow(() -> new RuntimeException("❌ Category not found with ID: " + categoryId));
	}

}
