package com.rviewer.skeletons.infrastructure.controllers;

import com.rviewer.skeletons.domain.services.OrderService;
import com.rviewer.skeletons.model.FoodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<FoodOrder>> getAllOrders() {
        List<FoodOrder> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<FoodOrder>> getOrdersByUser(@PathVariable String username) {
        List<FoodOrder> orders = orderService.getOrdersByUsername(username);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/create")
    public ResponseEntity<FoodOrder> createOrder(@RequestBody FoodOrder order) {
        FoodOrder savedOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(savedOrder);
    }
}
