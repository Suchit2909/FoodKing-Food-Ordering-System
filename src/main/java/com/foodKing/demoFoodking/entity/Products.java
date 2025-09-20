package com.foodKing.demoFoodking.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Products {
	
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	 
	 private String name;
	 private String description;
	 private Long price;
	 private String imageUrl;
	 private String moreDetails;
	 private boolean available;
	 
	 @ManyToOne
	 @JoinColumn(name = "category_id", nullable = false)
	 @JsonIgnoreProperties("products")
	 private Category category;
	 
	 

}
