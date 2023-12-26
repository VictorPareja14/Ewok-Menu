package com.rviewer.skeletons.domain.services;

import com.rviewer.skeletons.model.FoodOrder;
import com.rviewer.skeletons.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public FoodOrder saveOrder(FoodOrder order) {
        return orderRepository.save(order);
    }

    public List<FoodOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<FoodOrder> getOrdersByUsername(String username) {
        return orderRepository.findByUsername(username);
    }
}

