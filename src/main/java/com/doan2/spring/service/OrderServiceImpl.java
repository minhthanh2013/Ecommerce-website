package com.doan2.spring.service;

import com.doan2.spring.dao.order.OrderDAO;
import com.doan2.spring.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderDAO orderDAO;

    @Transactional
    @Override
    public List<Order> getOrders() {
        return orderDAO.getOrders();
    }

    @Transactional
    @Override
    public void saveOrder(Order theOrder) {
        orderDAO.saveOrder(theOrder);
    }

    @Transactional
    @Override
    public Order getOrder(int theId) {
        return orderDAO.getOrder(theId);
    }

    @Transactional
    @Override
    public void deleteOrder(int theId) {
        orderDAO.deleteOrder(theId);
    }
}
