package com.foodKing.demoFoodking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodKing.demoFoodking.bean.PaymentRequest;
import com.foodKing.demoFoodking.entity.UserOrder;
import com.foodKing.demoFoodking.services.OrderService;

@RestController
@RequestMapping("/api/auth/user/order")
@CrossOrigin("http://localhost:3000")
public class OrderController {
	
	@Autowired
	private OrderService orderservices;
	
	@PostMapping("/place")
	public ResponseEntity<UserOrder> placeOrder(
	        @RequestBody PaymentRequest request) {

	    UserOrder savedOrder = orderservices.placeOrder(request);
	    return ResponseEntity.ok(savedOrder);
	}
	

    @GetMapping("/user/{userId}")
	public ResponseEntity<List<UserOrder>> getOrders(@PathVariable Long userId) {
        return  ResponseEntity.ok(orderservices.getOrderbyUserId(userId));
    }
    
    
    @GetMapping("/latest")
    public ResponseEntity<UserOrder> getLatestOrder(@RequestParam Long userId) {
        return ResponseEntity.ok(orderservices.getLatestOrderByUserId(userId));
    }

}
