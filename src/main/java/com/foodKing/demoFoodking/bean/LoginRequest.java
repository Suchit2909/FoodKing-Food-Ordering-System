package com.foodKing.demoFoodking.bean;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
	private String username;
    private String password;
    private Set<String> roles;
    


}
