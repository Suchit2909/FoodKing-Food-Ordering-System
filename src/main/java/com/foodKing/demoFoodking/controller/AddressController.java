package com.foodKing.demoFoodking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodKing.demoFoodking.bean.AddressRequest;
import com.foodKing.demoFoodking.entity.Address;
import com.foodKing.demoFoodking.entity.User;
import com.foodKing.demoFoodking.repository.UserRepository;
import com.foodKing.demoFoodking.services.AddressService;
import com.foodKing.demoFoodking.services.registerLoginService;

@RestController
@RequestMapping("/api/user/address")
@CrossOrigin(origins = "http://localhost:3000")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	
	@Autowired
	private UserRepository userRepository;
	
	private User getCurrentUser() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("User not found: " + username));
		
	}
	
	
@PostMapping("/add")
	public  Address addAddress(@RequestBody AddressRequest request) {
	User user = getCurrentUser();
	return  addressService.addAddress(user, request);
}

@GetMapping("/list")
public List<Address> getAllAddresses() {
    User user = getCurrentUser();
    return addressService.getAllAddresses(user);
}

@DeleteMapping("/delete/{id}")
public void deleteAddress(@PathVariable Long id) {
    User user = getCurrentUser();
    addressService.deleteAddress(user, id);
}


}