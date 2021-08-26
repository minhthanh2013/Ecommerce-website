package com.doan2.spring.dao.order;

import com.doan2.spring.entity.Cart;
import com.doan2.spring.entity.CungCap;
import com.doan2.spring.entity.Order;
import com.doan2.spring.service.cart.CartService;
import com.doan2.spring.service.cungcap.CungCapService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.*;


@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    CungCapService cungCapService;
    @Autowired
    CartService cartService;

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

    @Override
    public List<Order> recentOrderThisWeek() {
        Session currentSession = sessionFactory.getCurrentSession();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        System.out.println(day+"\t"+month+"\t"+year);
        Query<Order> theQuery =
                currentSession.createQuery("from Order where day(date)="+day+" and month(date)="+month+" and year(date)="+year,
                        Order.class);
        //Query<Order> query = currentSession.createSQLQuery("select * from ORDER where idCus ="+cusId);
        List<Order> orders = theQuery.getResultList();

        // return the results
        return orders;
    }

    @Override
    public List<Order> getOrdersByIdSup(int idSup) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Integer> idproducts = cungCapService.getAllIdProductByIdSup(idSup);
        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < idproducts.size(); i++) {
            Cart cart = cartService.getListCartByIdProduct(idproducts.get(i));
            if (cart != null){
                if (cart.getIdOrder()!= null ){
                    Order order = getOrder(cart.getIdOrder());
                    orderList.add(order);
                }
            }
        }
        Set<Order> uniqueList = new HashSet<>(orderList);
        orderList.clear();
        orderList.addAll(uniqueList);


//        Query<Order> theQuery =
//                currentSession.createQuery("from Order where idSup ="+idSup,
//                        Order.class);
//        //Query<Order> query = currentSession.createSQLQuery("select * from ORDER where idCus ="+cusId);
//        List<Order> orders = theQuery.getResultList();

        // return the results
        return orderList;
    }

    @Override
    public void updateOrder(Order order) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(order);
    }

    @Override
    public BigInteger[] get12MonthRevenueByIdSup(int idSup) {
        Session currentSession = sessionFactory.getCurrentSession();
        String getMonth[] = new String[12];
        for(int i = 0; i<getMonth.length; i++) {
            getMonth[i] ="select SUM(CAST(total_money AS BIGINT)) from Order_Table where(MONTH(date) = '"+(i+1)+"')";
        }
        BigInteger res_value_month[] = new BigInteger[12];
        for(int i = 0; i<res_value_month.length; i++) {
            res_value_month[i] = (BigInteger) currentSession.createNativeQuery(getMonth[i]).uniqueResult();
        }
        for(int i = 0; i<res_value_month.length; i++) {
            if(res_value_month[i]==null)
                res_value_month[i]=BigInteger.ZERO;
        }
        //Integer thang1 =
        for(int i = 0; i<res_value_month.length; i++) {
            System.out.println(res_value_month[i]);
        }

        return res_value_month;
    }

    @Override
    public List<Integer> getLatestId() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery =currentSession.createSQLQuery("select max(idOrder) from Order_Table");
        return  theQuery.setMaxResults(1).getResultList();
    }


}
