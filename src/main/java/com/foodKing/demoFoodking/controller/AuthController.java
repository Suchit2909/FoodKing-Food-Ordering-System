package com.foodKing.demoFoodking.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodKing.demoFoodking.services.registerLoginService;

import com.foodKing.demoFoodking.bean.LoginRequest;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:3000")
public class AuthController {
	 @Autowired
	    private registerLoginService registerLoginService;

	    // ✅ Register User
	    @PostMapping("/register")
	    public ResponseEntity<String> registerUser(@RequestBody LoginRequest request) {
	        String response = registerLoginService.registerUser(request);
	        return ResponseEntity.ok(response);
	    }

	    @PostMapping("/login")
	    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody LoginRequest request) {
	        return ResponseEntity.ok(registerLoginService.loginUser(request));
	    }	
}
