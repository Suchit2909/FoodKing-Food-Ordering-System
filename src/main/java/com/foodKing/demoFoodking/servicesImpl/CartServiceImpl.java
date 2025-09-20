package com.foodKing.demoFoodking.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodKing.demoFoodking.bean.CartRequest;
import com.foodKing.demoFoodking.entity.Cart;
import com.foodKing.demoFoodking.repository.CartRepository;
import com.foodKing.demoFoodking.services.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart getOrCreateCart(Long userId) {
	 
		 return cartRepository.findByUserId(userId).orElseGet(() -> {
	            Cart newCart = new Cart();
	            newCart.setUserId(userId);
	            return cartRepository.save(newCart);
			
		});
	}

@Override
public void clearCart(Long cartId) {
	Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new RuntimeException("Cart not found"));
    cart.getItems().clear();
    cartRepository.save(cart);
}

}
