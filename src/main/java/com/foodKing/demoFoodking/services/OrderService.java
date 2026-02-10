package com.foodKing.demoFoodking.services;

import java.util.List;

import com.foodKing.demoFoodking.bean.PaymentRequest;
import com.foodKing.demoFoodking.entity.UserOrder;

public interface OrderService {
	
	public UserOrder placeOrder(PaymentRequest request);
	
	public List<UserOrder> getOrderbyUserId(Long userId);
	
	public UserOrder getLatestOrderByUserId(Long userId);

}
