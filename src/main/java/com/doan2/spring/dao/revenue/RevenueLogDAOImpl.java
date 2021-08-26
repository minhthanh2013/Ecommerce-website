package com.doan2.spring.dao.revenue;

import com.doan2.spring.entity.Order;
import com.doan2.spring.entity.RevenueLog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RevenueLogDAOImpl implements RevenueLogDAO{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<RevenueLog> getRevenues() {
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<RevenueLog> theQuery =
                currentSession.createQuery("from RevenueLog",
                        RevenueLog.class);

        // execute query and get result list
        List<RevenueLog> orders = theQuery.getResultList();

        // return the results
        return orders;
    }

    @Override
    public void saveRevenueLog(RevenueLog revenueLog) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(revenueLog);
    }

    @Override
    public RevenueLog getRevenueLog(int idLog) {
        Session currentSession = sessionFactory.getCurrentSession();
        RevenueLog order = currentSession.get(RevenueLog.class, idLog);
        return order;
    }

    @Override
    public void deleteRevenueLog(int idLog) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(idLog);
    }

    @Override
    public List<RevenueLog> getRevenueLogByCustomerId(int idCus) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<RevenueLog> theQuery =
                currentSession.createQuery("from RevenueLog where idCus ="+idCus,
                        RevenueLog.class);
        //Query<Order> query = currentSession.createSQLQuery("select * from ORDER where idCus ="+cusId);
        List<RevenueLog> orders = theQuery.getResultList();

        // return the results
        return orders;
    }

    @Override
    public void saveListRevenueLogs(List<RevenueLog> revenueLogList) {
        Session currentSession = sessionFactory.getCurrentSession();
        for (int i = 0; i < revenueLogList.size(); i++) {
            currentSession.saveOrUpdate(revenueLogList.get(i));
        }

    }

    @Override
    public List<RevenueLog> getRevenueLogByMonth(int month) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<RevenueLog> theQuery =
                currentSession.createQuery("from RevenueLog where MONTH(date) = "+month,
                        RevenueLog.class);
        //Query<Order> query = currentSession.createSQLQuery("select * from ORDER where idCus ="+cusId);
        List<RevenueLog> orders = theQuery.getResultList();

        return orders;
    }
}
