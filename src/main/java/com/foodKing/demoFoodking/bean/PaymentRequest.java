package com.foodKing.demoFoodking.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
	 private Long userId;
	    private Long cartId;
	    private Long addressId;

	    private Long amount; 
	    private String paymentId;
	    private String paymentMethod;

	   
	}
