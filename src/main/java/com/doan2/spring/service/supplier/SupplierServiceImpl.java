package com.doan2.spring.service.supplier;

import com.doan2.spring.entity.Supplier;
import com.doan2.spring.repository.SupplierRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService{
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Supplier> getSupplier(int theId) {
        return supplierRepository.findById(theId);
    }

    @Override
    @Transactional
    public Supplier getAllByPhone(String phone) {
        return supplierRepository.getAllByPhone(phone);
    }

    @Override
    @Transactional
    public void save(Supplier supplier) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(supplier);
    }


}
