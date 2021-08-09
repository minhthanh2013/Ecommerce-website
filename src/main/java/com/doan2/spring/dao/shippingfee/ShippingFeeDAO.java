package com.doan2.spring.dao.shippingfee;

import com.doan2.spring.entity.ShippingFee;

import java.util.List;

public interface ShippingFeeDAO {
    List<ShippingFee> getShippingFee();

    void saveShippingFee(ShippingFee theShippingFee);

    ShippingFee getShippingFee(int theId);

    void deleteShippingFee(int theId);
}
