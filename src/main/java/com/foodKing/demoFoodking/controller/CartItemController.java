package com.foodKing.demoFoodking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodKing.demoFoodking.bean.CartItemRequest;
import com.foodKing.demoFoodking.entity.CartItem;
import com.foodKing.demoFoodking.services.CartItemService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class CartItemController {
	
	@Autowired
	private CartItemService cartItemService;
	
	@PostMapping("/cartItem/add")
    public CartItem addCartItem(@RequestBody CartItemRequest request) {
        return cartItemService.addItemtoCart(request);
    }
	
	 @PutMapping("/update/{cartItemId}")
	    public CartItem updateQuantity(
	            @PathVariable Long cartItemId,
	            @RequestParam int quantity) {
	        return cartItemService.updateCartItemQuantity(cartItemId, quantity);
	    }

	 @DeleteMapping("/remove/{cartItemId}")
	    public String removeCartItem(@PathVariable Long cartItemId) {
	        cartItemService.removeCartitem(cartItemId);
	        return "Cart item removed successfully.";
	    }
	 
	 @GetMapping("/cartItems/{userId}")
	 public List<CartItem> getCartItemsByUser(@PathVariable Long userId) {
	     return cartItemService.getCartItem(userId);
	 }

}
