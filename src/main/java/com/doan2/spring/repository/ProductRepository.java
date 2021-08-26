package com.doan2.spring.repository;

import com.doan2.spring.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.idType = ?1")
    Page<Product> findAllByType(int type, Pageable pageable);
    @Query("select p from Product p where p.name like %?1%")
    Page<Product> findAllByName(String name, Pageable pageable);
    @Query("select count(p) from Product p where p.idType = ?1")
    int countByType(int type);
}
