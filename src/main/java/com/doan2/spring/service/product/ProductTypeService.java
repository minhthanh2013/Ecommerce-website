package com.doan2.spring.service.product;


import com.doan2.spring.entity.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductTypeService {
    List<ProductType> getAll();
    Optional<ProductType> getById(int id);
}
