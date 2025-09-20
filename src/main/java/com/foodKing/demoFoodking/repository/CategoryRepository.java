package com.foodKing.demoFoodking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodKing.demoFoodking.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
