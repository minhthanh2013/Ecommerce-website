package com.doan2.spring.service.product;

import com.doan2.spring.dao.product.ProductDAO;
import com.doan2.spring.entity.Product;
import com.doan2.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDAO productDAO;
    @Autowired
    ProductRepository productRepository;

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

    @Override
    @Transactional
    public void save(Product product) {
        productDAO.save(product);
    }

    @Override
    @Transactional
    public int getLatestIdProduct() {
        return productDAO.getLatestIdProduct();
    }

    @Override
    @Transactional
    public void update(Product product) {
        productDAO.update(product);
    }

    @Override
    @Transactional
    public List<Product> getListProductByType(int type) {
        return productDAO.getListProductByType(type);
    }

    @Override
    @Transactional
    public List<Product> newArrival(int top) {
        return productDAO.newArrival(top);
    }

    @Override
    @Transactional
    public Page<Product> findAllByType(int type, Pageable pageable) {
        return productRepository.findAllByType(type, pageable);
    }

    @Override
    @Transactional
    public Page<Product> findAllByName(String name, Pageable pageable) {
        return productRepository.findAllByName(name, pageable);
    }

    @Override
    @Transactional
    public int countByType(int type) {
        return productRepository.countByType(type);
    }
}
