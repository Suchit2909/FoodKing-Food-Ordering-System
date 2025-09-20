package com.foodKing.demoFoodking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartItem {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	 @ManyToOne
	    @JoinColumn(name = "cart_id", nullable = false)
	 @JsonIgnore
	 private Cart cart;
	 
	 @ManyToOne
	    @JoinColumn(name = "product_id", nullable = false)
	 private Products product;
	 
	 private int quantity;
}
