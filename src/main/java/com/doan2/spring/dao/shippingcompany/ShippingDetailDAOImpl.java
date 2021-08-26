package com.doan2.spring.dao.shippingcompany;

import com.doan2.spring.entity.Cart;
import com.doan2.spring.entity.ShippingDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ShippingDetailDAOImpl implements ShippingDetailDAO{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<ShippingDetail> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<ShippingDetail> theQuery =
                currentSession.createQuery("from ShippingDetail",
                        ShippingDetail.class);

        // execute query and get result list
        List<ShippingDetail> shippingDetailList = theQuery.getResultList();

        // return the results
        return shippingDetailList;
    }

    @Override
    public ShippingDetail getShippingDetailById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        ShippingDetail shippingDetail = currentSession.get(ShippingDetail.class, theId);
        return shippingDetail;
    }

    @Override
    public ShippingDetail getShippingDetailByIdOrder(int orderId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<ShippingDetail> theQuery =
                currentSession.createQuery("from ShippingDetail where idOrder="+orderId,
                        ShippingDetail.class);
        return theQuery.getSingleResult();
    }

    @Override
    public void save(ShippingDetail shippingDetail) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(shippingDetail);

    }

    @Override
    public void deleteShippingDetail(ShippingDetail shippingCompany) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(shippingCompany);

    }

    @Override
    public void saveListShippingDetail(List<ShippingDetail> shippingCompanyList) {
        Session currentSession = sessionFactory.getCurrentSession();
        for (ShippingDetail temp:
             shippingCompanyList) {
            currentSession.saveOrUpdate(temp);
        }
    }

    @Override
    public List<ShippingDetail> getListShippingDetailById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<ShippingDetail> theQuery =
                currentSession.createQuery("from ShippingDetail where idSCompany="+theId,
                        ShippingDetail.class);
        return theQuery.getResultList();
    }

    @Override
    public void addShippingDetail(ShippingDetail shippingDetail) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(shippingDetail);

    }
}
