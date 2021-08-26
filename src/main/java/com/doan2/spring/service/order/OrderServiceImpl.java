package com.doan2.spring.service.order;

import com.doan2.spring.dao.order.OrderDAO;
import com.doan2.spring.entity.Order;
import com.doan2.spring.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderDAO orderDAO;
    @Autowired
    OrderRepository orderRepository;

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

    @Transactional
    @Override
    public List<Order> getOrderByCustomerId(int id) {
        return orderDAO.getOrderByCustomerId(id);
    }
    @Transactional
    @Override
    public void saveListOrders(List<Order> orderList) {
        orderDAO.saveListOrders(orderList);
    }

    @Transactional
    @Override
    public List<Order> recentOrderThisWeek() {
        return orderDAO.recentOrderThisWeek();
    }
    @Transactional
    @Override
    public List<Order> getOrdersByIdSup(int idSup) {
        return orderDAO.getOrdersByIdSup(idSup);
    }
    @Transactional
    @Override
    public Page<Order> findByIdOrder(int idOrder, PageRequest pageRequest) {
        return orderRepository.findByIdOrder(idOrder, pageRequest);
    }
//    @Transactional
//    @Override
//    public Page<Order> findByIdSup(int idSup, Pageable pageable) {
//        return orderRepository.findByIdSup(idSup, pageable);
//    }
    @Transactional
    @Override
    public void updateOrder(Order order) {
        orderDAO.updateOrder(order);
    }

    @Override
    @Transactional
    public BigInteger[] get12MonthRevenueByIdSup(int idSup) {

        return orderDAO.get12MonthRevenueByIdSup(idSup);
    }

    @Override
    @Transactional
    public List<Integer> getLatestId() {
        return orderDAO.getLatestId();
    }

    @Override
    @Transactional
    public Page<Order> findByLastNDay(int day, Pageable pageable, int idCus) {
        return orderRepository.findByLastNDay(day,idCus, pageable);
    }

    @Override
    @Transactional
    public Page<Order> findByLastNMonth(int month, Pageable pageable, int idCus) {
        return orderRepository.findByLastNMonth(month, idCus, pageable );
    }

    @Override
    @Transactional
    public Page<Order> last5Order(Pageable pageable, int idCus) {
        return orderRepository.last5Order(idCus, pageable );
    }

    @Override
    @Transactional
    public Page<Order> findAllByYear(int year, Pageable pageable, int idCus) {
        return orderRepository.findAllByYear(year, idCus, pageable );
    }

    @Override
    @Transactional
    public Page<Order> findAllWithPage(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Page<Order> findAllByIdCus(int idCus, Pageable pageable) {
        return orderRepository.findAllByIdCus(idCus, pageable);
    }


}
