package com.doan2.spring.service.supplier;

import com.doan2.spring.entity.SupplierLog;

import java.math.BigDecimal;
import java.util.List;

public interface SupplierLogService {
    List<SupplierLog> getAll();
    List<SupplierLog> getAllBySupplierId(int idSup);
    BigDecimal getMonthRevenue(int month);
    BigDecimal getTotalRevenue();
    SupplierLog getSupplier(int theId);
    void save(SupplierLog supplierLog);
    List<Integer> getLatestIdLog();
}
