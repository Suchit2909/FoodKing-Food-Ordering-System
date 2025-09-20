package com.foodKing.demoFoodking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodKing.demoFoodking.bean.CategoryRequest;
import com.foodKing.demoFoodking.entity.Category;
import com.foodKing.demoFoodking.services.CategoryService;

@RestController
@RequestMapping("/api/admin/category")
@CrossOrigin("http://localhost:3000")
public class CategoryController {
	
	@Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody CategoryRequest request) {
        return ResponseEntity.ok(categoryService.createCategory(request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryService.getallCategories());
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest request) {
        String message = categoryService.updateCategory(id, request);
        return ResponseEntity.ok(message);
    }

}
