package com.foodKing.demoFoodking.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {
	  private String fullName;
	    private String street;
	    private String city;
	    private String state;
	    private String pinCode;
	    private String phone;

}
