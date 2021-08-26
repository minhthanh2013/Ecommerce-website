package com.doan2.spring.service.customer;

import com.doan2.spring.dao.customer.CustomerDAO;
import com.doan2.spring.entity.Customer;
import com.doan2.spring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerDAO customerDAO;
    @Autowired
    CustomerRepository customerRepository;
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

    @Override
    @Transactional
    public Boolean checkExistedEmail(String email, int idCus) {
        return customerDAO.checkExistedEmail(email, idCus);
    }

    @Override
    @Transactional
    public Page<Customer> findByName(String name, Pageable pageable) {
        return customerRepository.findByName(name, pageable);
    }

    @Override
    @Transactional
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
