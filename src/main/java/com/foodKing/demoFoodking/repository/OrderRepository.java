package com.foodKing.demoFoodking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodKing.demoFoodking.entity.UserOrder;

public interface OrderRepository extends JpaRepository<UserOrder, Long> {
	List<UserOrder> findByUserId(Long userId);
    Optional<UserOrder> findTopByUserIdOrderByOrderDateDesc(Long userId);
    
   

}
