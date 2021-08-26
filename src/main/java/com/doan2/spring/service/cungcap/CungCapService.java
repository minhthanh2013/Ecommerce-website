package com.doan2.spring.service.cungcap;

import com.doan2.spring.entity.CungCap;

import java.util.List;

public interface CungCapService {
    List<CungCap> getAll();
    CungCap getByIdProduct(int idProduct);
    int getInventoryByIdSup(int id);
    void save(CungCap cungCap);

    List<Integer> getAllIdProductByIdSup(int idSup);
}
