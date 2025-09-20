package com.foodKing.demoFoodking.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
	
	private Long id;              
    private String name;          // Product name
    private String description;   
    private Long price;           
    private String imageUrl;      
    private String moreDetails;  
    private boolean available;    
    private Long categoryId;

}
