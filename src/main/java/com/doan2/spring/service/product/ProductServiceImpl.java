package com.doan2.spring.service.product;

import com.doan2.spring.dao.product.ProductDAO;
import com.doan2.spring.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDAO productDAO;

    @Override
    @Transactional
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    @Transactional
    public List<Product> getByPages(int nbObjects) {
        return productDAO.getByPages(nbObjects);
    }

    @Override
    @Transactional
    public Product getProduct(int id) {
        return productDAO.getProduct(id);
    }
}
