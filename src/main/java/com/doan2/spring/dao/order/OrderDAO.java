package com.doan2.spring.dao.order;


import com.doan2.spring.entity.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getOrders();

    void saveOrder(Order theOrder);

    Order getOrder(int theId);

    void deleteOrder(int theId);

    List<Order> getOrderByCustomerId(int id);


    void saveListOrders(List<Order> orderList);
}
