package com.doan2.spring.dao.shippingcompany;

import com.doan2.spring.entity.ShippingDetail;

import java.util.List;

public interface ShippingDetailDAO {
    List<ShippingDetail> getAll();
    ShippingDetail getShippingDetailById(int theId);
    ShippingDetail getShippingDetailByIdOrder(int orderId);
    void save(ShippingDetail shippingDetail);
    void deleteShippingDetail(ShippingDetail shippingCompany);
    void saveListShippingDetail(List<ShippingDetail> shippingCompanyList);

    List<ShippingDetail> getListShippingDetailById(int theId);

    void addShippingDetail(ShippingDetail shippingDetail);
}
