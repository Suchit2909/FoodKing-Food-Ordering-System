package com.foodKing.demoFoodking.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodKing.demoFoodking.bean.CartItemRequest;
import com.foodKing.demoFoodking.entity.Cart;
import com.foodKing.demoFoodking.entity.CartItem;
import com.foodKing.demoFoodking.entity.Products;
import com.foodKing.demoFoodking.repository.CartItemRepository;
import com.foodKing.demoFoodking.repository.CartRepository;
import com.foodKing.demoFoodking.repository.ProductRepository;
import com.foodKing.demoFoodking.services.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {
	 @Autowired
	    private CartItemRepository cartItemRepository;

	    @Autowired
	    private CartRepository cartRepository;

	    @Autowired
	    private ProductRepository productRepository;


	    @Override
	    public CartItem addItemtoCart(CartItemRequest request) {
	        if (request.getCartId() == null) {
	            throw new IllegalArgumentException("Cart ID must not be null");
	        }

	        Cart cart = cartRepository.findById(request.getCartId())
	                .orElseThrow(() -> new RuntimeException("Cart not found"));

	        Products product = productRepository.findById(request.getProductId())
	                .orElseThrow(() -> new RuntimeException("Product not found"));
	        
	        Optional<CartItem> existingItemOpt = cartItemRepository.findByCartAndProduct(cart, product);
	        
	        if (existingItemOpt.isPresent()) {
	            CartItem existingItem = existingItemOpt.get();
	            existingItem.setQuantity(existingItem.getQuantity() + request.getQuantity()); // Increment quantity
	            return cartItemRepository.save(existingItem);
	        }
	        CartItem cartItem = new CartItem();
	        cartItem.setCart(cart);
	        cartItem.setProduct(product);
	        cartItem.setQuantity(request.getQuantity());

	        return cartItemRepository.save(cartItem);
	    }


	@Override
	public void removeCartitem(Long cartItemId) {
		if(!cartItemRepository.existsById(cartItemId)) {
			throw new RuntimeException("CartItem not found");
		}
		cartItemRepository.deleteById(cartItemId);

	}

	@Override
	public CartItem updateCartItemQuantity(Long cartItemId, int quantity) {
		 CartItem item = cartItemRepository.findById(cartItemId)
	                .orElseThrow(() -> new RuntimeException("CartItem not found"));

	        item.setQuantity(quantity);
	        return cartItemRepository.save(item);
	}

	@Override
	public List<CartItem> getCartItem(Long userId) {
		Cart cart = cartRepository.findByUserId(userId)
		        .orElseThrow(() -> new RuntimeException("Cart not found for user ID: " + userId));
		    return cartItemRepository.findByCart(cart);
	}

}
