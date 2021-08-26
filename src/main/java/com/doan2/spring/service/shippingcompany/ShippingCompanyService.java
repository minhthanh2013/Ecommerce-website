package com.doan2.spring.service.shippingcompany;

import com.doan2.spring.entity.ShippingCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ShippingCompanyService {
    List<ShippingCompany> getAll();
    ShippingCompany getShippingCompanyById(int theId);
    void save(ShippingCompany shippingCompany);
    void deleteShippingCompany(ShippingCompany shippingCompany);
    void saveListShippingCompany(List<ShippingCompany> shippingCompanyList);
    int getNumberOfData();
    Page<ShippingCompany>findByName(String name, Pageable pageable);
    //Page<ShippingCompany>findById(int id);
}
