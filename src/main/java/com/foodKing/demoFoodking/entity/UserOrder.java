package com.foodKing.demoFoodking.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class UserOrder {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private Long userId;
    private Long cartId;
    private Long addressId;
    private Long amount; // in paise or rupees
    private String paymentId;
    private String paymentMethod;

    private LocalDateTime orderDate = LocalDateTime.now();
}
