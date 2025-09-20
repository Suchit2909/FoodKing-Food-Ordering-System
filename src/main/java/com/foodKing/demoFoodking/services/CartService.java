package com.foodKing.demoFoodking.services;

import com.foodKing.demoFoodking.bean.CartRequest;
import com.foodKing.demoFoodking.entity.Cart;

public interface CartService {
	
	Cart getOrCreateCart(Long userId);
  
	void clearCart(Long cartId);

}
