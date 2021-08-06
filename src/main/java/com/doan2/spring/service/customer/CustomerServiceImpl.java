package com.doan2.spring.service.customer;

import com.doan2.spring.dao.customer.CustomerDAO;
import com.doan2.spring.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerDAO customerDAO;
    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }

    @Override
    @Transactional
    public Customer getCustomerByPhone(String phone) {
        return customerDAO.getCustomerByPhone(phone);
    }

    @Override
    @Transactional
    public boolean checkIfExists(String phone) {
        return customerDAO.checkIfExists(phone);
    }

    @Override
    @Transactional
    public int getLatestId() {
        return customerDAO.getLatestId();
    }
}
