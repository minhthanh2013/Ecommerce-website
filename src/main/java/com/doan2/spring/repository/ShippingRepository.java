package com.doan2.spring.repository;

import com.doan2.spring.entity.ShippingCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("shippingRepository")
public interface ShippingRepository extends JpaRepository<ShippingCompany, Integer> {

    @Query("select s from ShippingCompany s where s.nameSCompany like %?1%")
    Page<ShippingCompany> findByName(String name, Pageable pageable);

}
