package com.doan2.spring.dao.cungcap;

import com.doan2.spring.entity.CungCap;
import com.doan2.spring.entity.Product;

import java.util.List;

public interface CungCapDAO {
    List<CungCap> getAll();
    CungCap getByIdProduct(int idProduct);
    void save(CungCap cungCap);

    int getInventoryByIdSup(int id);

    List<Integer> getAllIdProductByIdSup(int idSup);
}
