package com.doan2.spring.service.shippingcompany;

import com.doan2.spring.dao.shippingcompany.ShippingCompanyDAO;
import com.doan2.spring.entity.ShippingCompany;
import com.doan2.spring.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service

public class ShippingCompanyServiceImpl implements ShippingCompanyService{


    @Autowired
    ShippingCompanyDAO shippingCompanyDAO;
    @Autowired
    ShippingRepository shippingRepository;
    @Override
    @Transactional
    public List<ShippingCompany> getAll() {
        return shippingCompanyDAO.getAll();
    }

    @Override
    @Transactional
    public ShippingCompany getShippingCompanyById(int theId) {
        return shippingCompanyDAO.getShippingCompanyById(theId);
    }

    @Override
    @Transactional
    public void save(ShippingCompany shippingCompany) {
        shippingCompanyDAO.save(shippingCompany);
    }

    @Override
    @Transactional
    public void deleteShippingCompany(ShippingCompany shippingCompany) {
        shippingCompanyDAO.deleteShippingCompany(shippingCompany);
    }

    @Override
    @Transactional
    public void saveListShippingCompany(List<ShippingCompany> shippingCompanyList) {
        shippingCompanyDAO.saveListShippingCompany(shippingCompanyList);
    }

    @Override
    @Transactional
    public int getNumberOfData() {
        return shippingCompanyDAO.getNumberOfData();
    }

    @Override
    @Transactional
    public Page<ShippingCompany> findByName(String name, Pageable pageable) {
        return shippingRepository.findByName(name, pageable);
    }




}
