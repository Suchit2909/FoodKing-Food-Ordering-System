package com.foodKing.demoFoodking.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemRequest {
	 private Long cartId;     // optional
	    private Long userId;     // used if cartId is null
	    private Long productId;
	    private int quantity;

}
