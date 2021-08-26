package com.doan2.spring.repository;

import com.doan2.spring.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productTypeRepository")
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {
}
