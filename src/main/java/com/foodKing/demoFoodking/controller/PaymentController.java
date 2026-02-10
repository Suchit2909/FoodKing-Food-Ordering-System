package com.foodKing.demoFoodking.controller;

import com.razorpay.RazorpayClient;
import com.foodKing.demoFoodking.entity.User;
import com.foodKing.demoFoodking.repository.UserRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user/payment")
@CrossOrigin("http://localhost:3000")
public class PaymentController {
	
	@Autowired
	private UserRepository userRepository;

    @Value("${razorpay.key_id}")
    private String keyId;

    @Value("${razorpay.key_secret}")
    private String keySecret;

    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestBody Map<String, Object> data)
            throws RazorpayException {

        int amount = (int) data.get("amount"); // amount in paise

        RazorpayClient client =
            new RazorpayClient(keyId, keySecret);

        JSONObject options = new JSONObject();
        options.put("amount", amount); // 🔥 SAME amount
        options.put("currency", "INR");
        options.put("receipt", "rcpt_" + System.currentTimeMillis());

        Order order = client.orders.create(options);

        return ResponseEntity.ok(order.toString());
    }

    @PostMapping("/success")
    public ResponseEntity<String> paymentSuccess(@RequestBody String payload) {
        System.out.println("Payment success payload: " + payload);
        return ResponseEntity.ok("Payment success (test mode)");
    }

}	

