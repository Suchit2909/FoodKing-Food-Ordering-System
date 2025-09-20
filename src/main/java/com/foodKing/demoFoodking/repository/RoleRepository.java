package com.foodKing.demoFoodking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodKing.demoFoodking.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Optional<Role> findByName(String name);

}
