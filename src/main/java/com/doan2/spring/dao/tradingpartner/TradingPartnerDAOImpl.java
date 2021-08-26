package com.doan2.spring.dao.tradingpartner;

import com.doan2.spring.entity.Cart;
import com.doan2.spring.entity.TradingPartner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TradingPartnerDAOImpl implements TradingPartnerDAO{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<TradingPartner> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<TradingPartner> theQuery =
                currentSession.createQuery("from TradingPartner",
                        TradingPartner.class);
        return theQuery.getResultList();
    }

    @Override
    public TradingPartner getTradingPartnerById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        TradingPartner theCustomer = currentSession.get(TradingPartner.class, theId);
        return theCustomer;
    }

    @Override
    public void save(TradingPartner tradingPartner) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(tradingPartner);
    }

    @Override
    public void deleteTradingPartner(TradingPartner tradingPartner) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(tradingPartner);
    }

    @Override
    public void saveListTradingPartner(List<TradingPartner> tradingPartnerList) {
        Session currentSession = sessionFactory.getCurrentSession();
        for (TradingPartner temp:
             tradingPartnerList) {
            currentSession.saveOrUpdate(temp);
        }
    }

    @Override
    public List<Integer> getIdPartnerByName(String name) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery =currentSession.createSQLQuery("select idPartner from trading_partner where namePartner = '"+ name+"'");
        return  theQuery.setMaxResults(1).getResultList();
    }
}
