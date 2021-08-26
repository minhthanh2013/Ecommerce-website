package com.doan2.spring.service.cungcap;

import com.doan2.spring.dao.cungcap.CungCapDAO;
import com.doan2.spring.entity.CungCap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class CungCapServiceImpl implements CungCapService{

    @Autowired
    CungCapDAO cungCapDAO;

    @Override
    @Transactional
    public List<CungCap> getAll() {
        return cungCapDAO.getAll();
    }

    @Override
    @Transactional
    public CungCap getByIdProduct(int idProduct) {
        return cungCapDAO.getByIdProduct(idProduct);
    }

    @Override
    public int getInventoryByIdSup(int id) {
        return cungCapDAO.getInventoryByIdSup(id);
    }

    @Override
    @Transactional
    public void save(CungCap cungCap) {
        cungCapDAO.save(cungCap);
    }

    @Override
    @Transactional
    public List<Integer> getAllIdProductByIdSup(int idSup) {
        return cungCapDAO.getAllIdProductByIdSup(idSup);
    }

}
