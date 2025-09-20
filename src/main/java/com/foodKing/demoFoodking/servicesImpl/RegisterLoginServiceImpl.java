package com.foodKing.demoFoodking.servicesImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.foodKing.demoFoodking.bean.LoginRequest;
import com.foodKing.demoFoodking.entity.Cart;
import com.foodKing.demoFoodking.entity.Role;
import com.foodKing.demoFoodking.entity.User;
import com.foodKing.demoFoodking.repository.CartRepository;
import com.foodKing.demoFoodking.repository.RoleRepository;
import com.foodKing.demoFoodking.repository.UserRepository;
import com.foodKing.demoFoodking.services.registerLoginService;
import com.foodKing.demoFoodking.util.JwtUtil;

@Service
public class RegisterLoginServiceImpl implements registerLoginService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private CartRepository cartRepository;

    @Override
    public String registerUser(LoginRequest request) {
        if (userRepo.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("❌ Username already exists!");
        }

        Set<Role> roleSet = request.getRoles().stream()
                .map(Role::new)
                .collect(Collectors.toSet());

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(roleSet);

        userRepo.save(user);

        return "✅ User registered successfully!";
    }

   
    @Override
public Map<String, Object> loginUser(LoginRequest request) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

    User user = userRepo.findByUsername(request.getUsername())
        .orElseThrow(() -> new RuntimeException("❌ User not found"));

    String role = user.getRoles().iterator().next().getName();
    String token = jwtUtil.generateToken(user.getUsername(), role);

    // ✅ Get or create cart
    Cart cart = cartRepository.findByUserId(user.getId())
        .orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUserId(user.getId());
            return cartRepository.save(newCart);
        });

    Map<String, Object> response = new HashMap<>();
    response.put("token", token);
    response.put("username", user.getUsername());
    response.put("role", role);
    response.put("userId", user.getId());

    // ✅ Send cartId safely
    Map<String, Object> cartMap = new HashMap<>();
    cartMap.put("id", cart.getId());
    response.put("cart", cartMap);

    return response;
}

       
}
