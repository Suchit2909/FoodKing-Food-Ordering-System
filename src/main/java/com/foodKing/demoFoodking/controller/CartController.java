package com.foodKing.demoFoodking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodKing.demoFoodking.bean.CartRequest;
import com.foodKing.demoFoodking.entity.Cart;
import com.foodKing.demoFoodking.services.CartService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
	

    @Autowired
    private CartService cartService;
    
    @PostMapping("/cart/create")
    public ResponseEntity<Cart> createCart(@RequestBody CartRequest cartRequest) {
        Cart cart = cartService.getOrCreateCart(cartRequest.getUserId());
        return ResponseEntity.ok(cart);
    }

    // ✅ Get or Create Cart for a User
//    @GetMapping("/cart/{userId}")
//    public Cart getOrCreateCart(@PathVariable Long userId) {
//        return cartService.getOrCreateCart(userId);
//    }

    // ✅ Optionally: Clear cart (remove all items)
    @DeleteMapping("/clear/{cartId}")
    public String clearCart(@PathVariable Long cartId) {
        cartService.clearCart(cartId);
        return "Cart cleared successfully.";
    }

}
