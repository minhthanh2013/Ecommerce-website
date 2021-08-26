package com.doan2.spring.service.supplier;

import com.doan2.spring.entity.SupplierLog;
import com.doan2.spring.repository.SupplierLogRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

@Service
public class SupplierLogServiceImpl implements SupplierLogService{
    @Autowired
    SupplierLogRepository supplierLogRepository;
    @Autowired
    SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<SupplierLog> getAll() {
        return supplierLogRepository.findAll();
    }

    @Override
    @Transactional
    public List<SupplierLog> getAllBySupplierId(int idSup) {
        return supplierLogRepository.getAllBySupplierId(idSup);
    }

    @Override
    @Transactional
    public BigDecimal getMonthRevenue(int month) {
        List<SupplierLog> supplierLogList = supplierLogRepository.getMonthRevenueList(month);
        System.out.println("31 "+supplierLogList);
        double sum = 0 ;
        for (int i = 0; i < supplierLogList.size(); i++) {
            sum += supplierLogList.get(i).getTotalMoney();
        }
        BigDecimal tempBig = new BigDecimal(Double.toString(sum));
        System.out.println(sum);
        return tempBig;
    }

    @Override
    @Transactional
    public BigDecimal getTotalRevenue() {
        List<SupplierLog> supplierLogList = getAll();
        double sum = 0;
        for (int i = 0; i < supplierLogList.size(); i++) {
            sum += supplierLogList.get(i).getTotalMoney();
        }
        System.out.println(sum);
        BigDecimal tempBig = new BigDecimal(Double.toString(sum));
        return tempBig;
    }

    @Override
    @Transactional
    public SupplierLog getSupplier(int theId) {
        return supplierLogRepository.getOne(theId);
    }

    @Override
    @Transactional
    public void save(SupplierLog supplierLog) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(supplierLog);
    }

    @Override
    @Transactional
    public List<Integer> getLatestIdLog() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createSQLQuery("select max(idLog) from supplier_log");

        return theQuery.setMaxResults(1).getResultList();
    }
}
