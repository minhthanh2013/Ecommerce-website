package com.doan2.spring.repository;


import com.doan2.spring.entity.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("supplierRepository")
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    @Query("select s from Supplier s where s.nameSup like %?1%")
    Page<Supplier> findByName(String name, Pageable pageable);
    @Query("select s from Supplier  s where s.phone = ?1")
    Supplier getAllByPhone(String phone);
}
