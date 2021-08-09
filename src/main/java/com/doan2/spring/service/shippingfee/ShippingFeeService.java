package com.doan2.spring.service.shippingfee;


import com.doan2.spring.entity.ShippingFee;

import java.util.List;

public interface ShippingFeeService {
    List<ShippingFee> getShippingFee();

    void saveShippingFee(ShippingFee theShippingFee);

    ShippingFee getShippingFee(int theId);

    void deleteShippingFee(int theId);

}
