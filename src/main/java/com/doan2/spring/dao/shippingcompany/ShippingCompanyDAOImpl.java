package com.doan2.spring.dao.shippingcompany;

import com.doan2.spring.entity.Cart;
import com.doan2.spring.entity.Product;
import com.doan2.spring.entity.ShippingCompany;
import com.doan2.spring.entity.ShippingDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ShippingCompanyDAOImpl implements ShippingCompanyDAO{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<ShippingCompany> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<ShippingCompany> theQuery =
                currentSession.createQuery("from ShippingCompany",
                        ShippingCompany.class);
        return theQuery.getResultList();
    }

    @Override
    public ShippingCompany getShippingCompanyById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Query<ShippingCompany> theQuery =
                currentSession.createQuery("from ShippingCompany where idSCompany="+theId,
                        ShippingCompany.class);
        System.out.println(theQuery.getSingleResult());
        return theQuery.getSingleResult();
    }

    @Override
    public void save(ShippingCompany shippingCompany) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(shippingCompany);
    }

    @Override
    public void deleteShippingCompany(ShippingCompany shippingCompany) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(shippingCompany);
    }

    @Override
    public void saveListShippingCompany(List<ShippingCompany> shippingCompanyList) {
        Session currentSession = sessionFactory.getCurrentSession();
        for (ShippingCompany temp:
                shippingCompanyList) {
            currentSession.saveOrUpdate(temp);
        }
    }

    @Override
    public int getNumberOfData() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createSQLQuery("select max(idSCompany) from Shipping_Company");
        return query.getFirstResult();
    }




}
