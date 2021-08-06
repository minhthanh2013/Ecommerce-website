package com.doan2.spring.dao.customer;

import com.doan2.spring.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Customer theCustomer = currentSession.get(Customer.class, id);

        return theCustomer;
    }

    @Override
    public Customer getCustomerByPhone(String phone) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("SELECT u FROM Customer u WHERE u.phone=:phoneParam");
        query.setParameter("phoneParam", phone);
//        Query<Customer> theQuery =
//                currentSession.createQuery("from Customer where phone="+phone,
//                        Customer.class);

        // execute query and get result list
        Customer temp = (Customer) query.getSingleResult();
        return temp;
    }

    @Override
    public boolean checkIfExists(String phone) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("SELECT u FROM Customer u WHERE u.phone=:phoneParam");
        query.setParameter("phoneParam", phone);
//        Query<Customer> theQuery =
//                currentSession.createQuery("from Customer where phone="+phone,
//                        Customer.class);

        // execute query and get result list
        return (query.uniqueResult() != null);
    }

    @Override
    public int getLatestId() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("SELECT max(u.id) FROM Customer u ");

        return (int) query.getSingleResult();
    }
}
