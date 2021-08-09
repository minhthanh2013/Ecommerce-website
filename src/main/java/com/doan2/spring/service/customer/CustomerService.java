package com.doan2.spring.service.customer;

import com.doan2.spring.entity.Customer;

public interface CustomerService {
    void saveCustomer(Customer customer);
    Customer getCustomerById(int id);
    Customer getCustomerByPhone(String phone);
    boolean checkIfExists(String phone);
    int getLatestId();
    Boolean checkExistedEmail(String email, int idCus);
}
