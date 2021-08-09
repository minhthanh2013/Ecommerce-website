package com.doan2.spring.dao.shippingfee;


import com.doan2.spring.entity.ShippingFee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ShippingFeeDAOImpl implements ShippingFeeDAO{

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<ShippingFee> getShippingFee() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<ShippingFee> theQuery =
                currentSession.createQuery("from ShippingFee",
                        ShippingFee.class);

        // execute query and get result list
        List<ShippingFee> shippingFees = theQuery.getResultList();

        // return the results
        return shippingFees;
    }

    @Override
    public void saveShippingFee(ShippingFee theShippingFee) {
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the customer ... finally LOL
        currentSession.saveOrUpdate(theShippingFee);
    }

    @Override
    public ShippingFee getShippingFee(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        ShippingFee theShippingFee = currentSession.get(ShippingFee.class, theId);

        return theShippingFee;
    }

    @Override
    public void deleteShippingFee(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from ShippingFee where id=:shippingId");
        theQuery.setParameter("shippingId", theId);

        theQuery.executeUpdate();
    }
}
