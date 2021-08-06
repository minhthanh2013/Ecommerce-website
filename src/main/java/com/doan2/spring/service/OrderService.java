package com.doan2.spring.service;

import com.doan2.spring.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();

    void saveOrder(Order theOrder);

    Order getOrder(int theId);

    void deleteOrder(int theId);
}
