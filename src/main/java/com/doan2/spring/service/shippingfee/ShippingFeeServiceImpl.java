package com.doan2.spring.service.shippingfee;

import com.doan2.spring.dao.shippingfee.ShippingFeeDAO;
import com.doan2.spring.entity.ShippingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ShippingFeeServiceImpl implements ShippingFeeService{
    @Autowired
    ShippingFeeDAO shippingFeeDAO;
    @Transactional
    @Override
    public List<ShippingFee> getShippingFee() {
        return shippingFeeDAO.getShippingFee();
    }
    @Transactional
    @Override
    public void saveShippingFee(ShippingFee theShippingFee) {
        shippingFeeDAO.saveShippingFee(theShippingFee);
    }
    @Transactional
    @Override
    public ShippingFee getShippingFee(int theId) {
        return shippingFeeDAO.getShippingFee(theId);
    }
    @Transactional
    @Override
    public void deleteShippingFee(int theId) {
        shippingFeeDAO.deleteShippingFee(theId);
    }
}
