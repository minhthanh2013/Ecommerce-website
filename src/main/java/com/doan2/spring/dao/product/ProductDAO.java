package com.doan2.spring.dao.product;

import com.doan2.spring.entity.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAll();
    List<Product> getByPages(int nbObjects);
    Product getProduct(int id);

    void save(Product product);

    int getLatestIdProduct();

    void update(Product product);

    List<Product> getListProductByType(int type);

    List<Product> newArrival(int top);
}
