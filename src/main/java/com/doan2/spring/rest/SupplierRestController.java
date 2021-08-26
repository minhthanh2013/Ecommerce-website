package com.doan2.spring.rest;

import com.doan2.spring.entity.ShippingCompany;
import com.doan2.spring.entity.Supplier;
import com.doan2.spring.repository.SupplierRepository;
import com.doan2.spring.service.shippingcompany.ShippingCompanyService;
import com.doan2.spring.service.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/supplier")
public class SupplierRestController {
    @Autowired
    SupplierRepository supplierRepository;

    @GetMapping("/suppliers")
    public Page<Supplier> getAllWithPages(@RequestParam Optional<String> name,
                                          @RequestParam Optional<Integer> page){
        return supplierRepository.findByName(name.orElse("_"), new PageRequest(
                page.orElse(0), 5
        ));

    }
}
