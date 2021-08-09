package com.doan2.spring.dao.cungcap;

import com.doan2.spring.entity.CungCap;
import com.doan2.spring.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CungCapDAOImpl implements CungCapDAO{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<CungCap> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<CungCap> theQuery =
                currentSession.createQuery("from CungCap",
                        CungCap.class);

        // execute query and get result list
        List<CungCap> products = theQuery.getResultList();

        // return the results
        return products;
    }

    @Override
    public CungCap getByIdProduct(int idProduct) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<CungCap> theQuery =
                currentSession.createQuery("from CungCap where idProduct="+idProduct,
                        CungCap.class);
        CungCap cungCap = theQuery.getSingleResult();
        return cungCap;
    }

    @Override
    public void save(CungCap cungCap) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(cungCap);
    }


}
