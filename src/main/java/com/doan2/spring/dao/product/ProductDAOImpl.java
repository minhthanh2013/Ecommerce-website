package com.doan2.spring.dao.product;

import com.doan2.spring.entity.Cart;
import com.doan2.spring.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductDAOImpl implements ProductDAO{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Product> getAll() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<Product> theQuery =
                currentSession.createQuery("from Product",
                        Product.class);

        // execute query and get result list
        List<Product> products = theQuery.getResultList();

        // return the results
        return products;

    }

    @Override
    public List<Product> getByPages(int nbObjects) {
        return null;
    }

    @Override
    public Product getProduct(int id) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Product product = currentSession.get(Product.class, id);

        return product;
    }
}
