package com.doan2.spring.service.shippingcompany;

import com.doan2.spring.entity.ShippingCompany;
import com.doan2.spring.entity.ShippingDetail;

import java.util.List;

public interface ShippingDetailService {
    List<ShippingDetail> getAll();
    ShippingDetail getShippingDetailById(int theId);
    ShippingDetail getShippingDetailByIdOrder(int orderId);
    void save(ShippingDetail shippingDetail);
    void addShippingDetail(ShippingDetail shippingDetail);
    void deleteShippingDetail(ShippingDetail shippingCompany);
    void saveListShippingDetail(List<ShippingDetail> shippingCompanyList);
    List<ShippingDetail> getListShippingDetailById(int theId);
}
