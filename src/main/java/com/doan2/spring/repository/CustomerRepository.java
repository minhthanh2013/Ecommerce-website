package com.doan2.spring.repository;

import com.doan2.spring.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select s from Customer s where s.nameCus like %?1%")
    Page<Customer> findByName(String name, Pageable pageable);
}
