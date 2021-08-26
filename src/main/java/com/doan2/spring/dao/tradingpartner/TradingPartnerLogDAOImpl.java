package com.doan2.spring.dao.tradingpartner;


import com.doan2.spring.entity.Cart;
import com.doan2.spring.entity.TradingPartnerLog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TradingPartnerLogDAOImpl implements TradingPartnerLogDAO{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<TradingPartnerLog> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<TradingPartnerLog> theQuery =
                currentSession.createQuery("from TradingPartnerLog",
                        TradingPartnerLog.class);
        return theQuery.getResultList();
    }

    @Override
    public TradingPartnerLog getTradingPartnerLogById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        TradingPartnerLog theCustomer = currentSession.get(TradingPartnerLog.class, theId);
        return theCustomer;
    }

    @Override
    public TradingPartnerLog getTradingPartnerLogByIdOrder(int orderId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<TradingPartnerLog> theQuery =
                currentSession.createQuery("from TradingPartnerLog where idOrder="+orderId,
                        TradingPartnerLog.class);
        return theQuery.setMaxResults(1).getResultList().get(0);
    }

    @Override
    public void save(TradingPartnerLog shippingDetail) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(shippingDetail);
    }

    @Override
    public void deleteTradingPartnerLog(TradingPartnerLog tradingPartnerLog) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(tradingPartnerLog);
    }

    @Override
    public void saveListTradingPartnerLog(List<TradingPartnerLog> tradingPartnerLogList) {
        Session currentSession = sessionFactory.getCurrentSession();
        for (TradingPartnerLog temp:
                tradingPartnerLogList) {
            currentSession.saveOrUpdate(temp);
        }
    }

    @Override
    public List<TradingPartnerLog> getAllByIdSup(int idPartner) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<TradingPartnerLog> theQuery =
                currentSession.createQuery("from TradingPartnerLog where idPartner="+idPartner,
                        TradingPartnerLog.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Integer> getLatestIdLog() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createSQLQuery("select max(idLog) from tradingPartner_log");
        return theQuery.setMaxResults(1).getResultList();
    }
}
