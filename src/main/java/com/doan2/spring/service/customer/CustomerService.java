package com.doan2.spring.service.customer;

import com.doan2.spring.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);
    Customer getCustomerById(int id);
    Customer getCustomerByPhone(String phone);
    boolean checkIfExists(String phone);
    int getLatestId();
    Boolean checkExistedEmail(String email, int idCus);
    Page<Customer> findByName(String name, Pageable pageable);

    List<Customer> getAll();
}
