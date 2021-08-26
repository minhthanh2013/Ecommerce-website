package com.doan2.spring.service.supplier;

import com.doan2.spring.entity.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<Supplier> getAll();
    Optional<Supplier> getSupplier(int theId);
    Supplier getAllByPhone(String phone);
    void save(Supplier supplier);
}
