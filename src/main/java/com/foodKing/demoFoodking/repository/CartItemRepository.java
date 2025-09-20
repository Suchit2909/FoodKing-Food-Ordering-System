package com.foodKing.demoFoodking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodKing.demoFoodking.entity.Cart;
import com.foodKing.demoFoodking.entity.CartItem;
import com.foodKing.demoFoodking.entity.Products;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{
	
	 List<CartItem> findByCart(Cart cart);
	 
	 Optional<CartItem> findByCartAndProduct(Cart cart, Products product);

}
