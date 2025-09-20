package com.foodKing.demoFoodking.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@RestController
@RequestMapping("/api/auth/payment")
@CrossOrigin("http://localhost:3000")
public class PaymentController {
	
	@Value("${razorpay.key.secret}")
    private String razorpaySecret;
	
	@PostMapping("/create-order")
	public ResponseEntity<?> createOrder(@RequestBody Map<String, Object> request) {
        try {
        	 Object amountObj = request.get("amount");
             int amount = Integer.parseInt(amountObj.toString());

            RazorpayClient client = new RazorpayClient("rzp_test_RJTy244ttMYNmU", "qeNlpQu7b7sKz8oj5l0Emlc7");

            JSONObject options = new JSONObject();
            options.put("amount", amount * 100); // in paise
            options.put("currency", "INR");
            options.put("receipt", "txn_" + System.currentTimeMillis());

            // Create order in Razorpay
            Order order = client.orders.create(options);

            return ResponseEntity.ok(Map.of("orderData", order.toString()));
        } catch (Exception e) {
        	  e.printStackTrace(); // 👈 will print full error in logs
              return ResponseEntity.status(500).body("Error creating order: " + e.getMessage());
        }
    }

    // ✅ After Payment Success
    @PostMapping("/place-after-payment")
    public ResponseEntity<?> placeAfterPayment(@RequestBody Map<String, Object> data) {
        System.out.println("Payment Success Data: " + data);
        return ResponseEntity.ok("Order placed successfully!");
    }
	
}
