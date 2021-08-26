package com.doan2.spring.service.shippingcompany;

import com.doan2.spring.dao.shippingcompany.ShippingDetailDAO;
import com.doan2.spring.entity.ShippingDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShippingDetailServiceImpl implements ShippingDetailService{
    @Autowired
    ShippingDetailDAO shippingDetailDAO;
    @Override
    @Transactional
    public List<ShippingDetail> getAll() {
        return shippingDetailDAO.getAll();
    }

    @Override
    @Transactional
    public ShippingDetail getShippingDetailById(int theId) {
        return shippingDetailDAO.getShippingDetailById(theId);
    }

    @Override
    @Transactional
    public ShippingDetail getShippingDetailByIdOrder(int orderId) {
        return shippingDetailDAO.getShippingDetailByIdOrder(orderId);
    }

    @Override
    @Transactional
    public void save(ShippingDetail shippingDetail) {
        shippingDetailDAO.save(shippingDetail);
    }

    @Override
    @Transactional
    public void addShippingDetail(ShippingDetail shippingDetail) {
        shippingDetailDAO.addShippingDetail(shippingDetail);
    }

    @Override
    @Transactional
    public void deleteShippingDetail(ShippingDetail shippingCompany) {
        shippingDetailDAO.deleteShippingDetail(shippingCompany);
    }

    @Override
    @Transactional
    public void saveListShippingDetail(List<ShippingDetail> shippingCompanyList) {
        shippingDetailDAO.saveListShippingDetail(shippingCompanyList);
    }

    @Override
    @Transactional
    public List<ShippingDetail> getListShippingDetailById(int theId) {
        return shippingDetailDAO.getListShippingDetailById(theId);
    }
}
