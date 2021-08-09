package com.doan2.spring.dao.order;

import com.doan2.spring.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Order> getOrders() {
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<Order> theQuery =
                currentSession.createQuery("from Order",
                        Order.class);

        // execute query and get result list
        List<Order> orders = theQuery.getResultList();

        // return the results
        return orders;
    }

    @Override
    public void saveOrder(Order theOrder) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(theOrder);
    }

    @Override
    public Order getOrder(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Order order = currentSession.get(Order.class, theId);
        return order;
    }

    @Override
    public void deleteOrder(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(theId);
    }

    @Override
    public List<Order> getOrderByCustomerId(int cusId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Order> theQuery =
                currentSession.createQuery("from Order where idCus ="+cusId,
                        Order.class);
        //Query<Order> query = currentSession.createSQLQuery("select * from ORDER where idCus ="+cusId);
        List<Order> orders = theQuery.getResultList();

        // return the results
        return orders;
    }

    @Override
    public void saveListOrders(List<Order> orderList) {
        Session currentSession = sessionFactory.getCurrentSession();
        for (int i = 0; i < orderList.size(); i++) {
            currentSession.saveOrUpdate(orderList.get(i));
        }

    }


}
