package com.foodKing.demoFoodking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodKing.demoFoodking.entity.Address;
import com.foodKing.demoFoodking.entity.User;

public interface AddressRepository extends JpaRepository<Address,Long> {
	
	List<Address>findByUser(User user);

}
