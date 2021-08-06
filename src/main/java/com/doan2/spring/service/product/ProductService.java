package com.doan2.spring.service.product;


import com.doan2.spring.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    List<Product> getByPages(int nbObjects);
    Product getProduct(int id);

}
