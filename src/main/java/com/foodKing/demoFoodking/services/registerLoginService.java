package com.foodKing.demoFoodking.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.foodKing.demoFoodking.bean.LoginRequest;


public interface registerLoginService {
	
	public String registerUser(LoginRequest request);
	 public Map<String, Object> loginUser(LoginRequest request);

}
