package com.doan2.spring.service.order;

import com.doan2.spring.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface OrderService {
    List<Order> getOrders();

    void saveOrder(Order theOrder);

    Order getOrder(int theId);

    void deleteOrder(int theId);

    List<Order> getOrderByCustomerId(int id);

    void saveListOrders(List<Order> orderList);

    List<Order> recentOrderThisWeek();

    List<Order> getOrdersByIdSup(int idSup);

    Page<Order> findByIdOrder(int idOrder, PageRequest pageRequest);

//    Page<Order> findByIdSup(int idSup, Pageable pageable);

    void updateOrder(Order order);

    BigInteger[] get12MonthRevenueByIdSup(int idSup);

    List<Integer> getLatestId();

    Page<Order> findByLastNDay(int day, Pageable pageable, int idCus);

    Page<Order> findByLastNMonth(int month, Pageable pageable, int idCus);

    Page<Order> last5Order(Pageable pageable, int idCus);
    Page<Order> findAllByYear(int year, Pageable pageable, int idCus);

    Page<Order> findAllWithPage(Pageable pageable);

    Page<Order> findAllByIdCus(int idCus, Pageable pageable);
}
