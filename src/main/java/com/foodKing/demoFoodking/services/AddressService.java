package com.foodKing.demoFoodking.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foodKing.demoFoodking.bean.AddressRequest;
import com.foodKing.demoFoodking.entity.Address;
import com.foodKing.demoFoodking.entity.User;


public interface AddressService {
	
	Address addAddress(User user , AddressRequest addressRequest);
	
	List<Address>getAllAddresses(User user);
	
	void deleteAddress(User user, Long AddressId);
	

}
