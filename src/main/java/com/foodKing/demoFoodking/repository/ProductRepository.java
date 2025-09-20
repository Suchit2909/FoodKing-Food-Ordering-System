package com.foodKing.demoFoodking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodKing.demoFoodking.entity.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
