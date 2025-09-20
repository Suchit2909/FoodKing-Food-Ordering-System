package com.foodKing.demoFoodking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodKing.demoFoodking.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	 Optional<User> findByUsername(String username);

}
