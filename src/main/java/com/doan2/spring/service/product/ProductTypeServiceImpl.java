package com.doan2.spring.service.product;

import com.doan2.spring.entity.ProductType;
import com.doan2.spring.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService{
    @Autowired
    ProductTypeRepository productTypeRepository;
    @Override
    public List<ProductType> getAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public Optional<ProductType> getById(int id) {
        return productTypeRepository.findById(id);
    }

}
