package com.doan2.spring.service.cungcap;

import com.doan2.spring.entity.CungCap;

import java.util.List;

public interface CungCapService {
    List<CungCap> getAll();
    CungCap getByIdProduct(int idProduct);
    void save(CungCap cungCap);

}
