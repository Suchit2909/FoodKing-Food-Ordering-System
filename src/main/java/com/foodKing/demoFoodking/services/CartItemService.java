package com.foodKing.demoFoodking.services;

import java.util.List;

import com.foodKing.demoFoodking.bean.CartItemRequest;
import com.foodKing.demoFoodking.entity.CartItem;

public interface CartItemService {
	
	CartItem addItemtoCart(CartItemRequest request);
	
	void removeCartitem(Long cartItemId);
	
	 CartItem updateCartItemQuantity(Long cartItemId, int quantity);
	 
	 List<CartItem> getCartItem( Long userId);
	 
	 
	
	
	
	
	

}
