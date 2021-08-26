package com.doan2.spring.repository;

import com.doan2.spring.entity.SupplierLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("supplierLogRepository")
public interface SupplierLogRepository extends JpaRepository<SupplierLog, Integer> {
    @Query("select s from SupplierLog s where s.idSup = ?1")
    List<SupplierLog> getAllBySupplierId(int idSup);
    @Query("select s from SupplierLog s where month(s.date) = ?1")
    List<SupplierLog> getMonthRevenueList(int month);
}
