package com.foodKing.demoFoodking.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodKing.demoFoodking.bean.PaymentRequest;
import com.foodKing.demoFoodking.entity.UserOrder;
import com.foodKing.demoFoodking.repository.CartItemRepository;
import com.foodKing.demoFoodking.repository.OrderRepository;
import com.foodKing.demoFoodking.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    @Transactional
    public UserOrder placeOrder(PaymentRequest req) {

        // 1️⃣ Build Order entity (BACKEND CONTROLLED)
        UserOrder order = new UserOrder();
        order.setUserId(req.getUserId());
        order.setAddressId(req.getAddressId());
        order.setAmount(req.getAmount());
        order.setPaymentId(req.getPaymentId());
        order.setPaymentMethod(req.getPaymentMethod());

        // ❌ DO NOT SET cartId (it causes null issues)
        // order.setCartId(req.getCartId());

        // 2️⃣ Save order
        UserOrder savedOrder = orderRepo.save(order);

        // 3️⃣ Clear cart using Cart → UserId mapping
        cartItemRepository.deleteByCart_UserId(req.getUserId());

        return savedOrder;
    }

    @Override
    public List<UserOrder> getOrderbyUserId(Long userId) {
        return orderRepo.findByUserId(userId);
    }

    @Override
    public UserOrder getLatestOrderByUserId(Long userId) {
        return orderRepo.findTopByUserIdOrderByOrderDateDesc(userId)
                        .orElse(null);
    }
}
