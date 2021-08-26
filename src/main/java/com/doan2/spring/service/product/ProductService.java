package com.doan2.spring.service.product;


import com.doan2.spring.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    List<Product> getByPages(int nbObjects);
    Product getProduct(int id);
    void save(Product product);
    int getLatestIdProduct();
    void update(Product product);
    List<Product> getListProductByType(int type);
    List<Product> newArrival(int top);
    Page<Product> findAllByType(int type, Pageable pageable);
    Page<Product> findAllByName(String name, Pageable pageable);
    int countByType(int type);

}
