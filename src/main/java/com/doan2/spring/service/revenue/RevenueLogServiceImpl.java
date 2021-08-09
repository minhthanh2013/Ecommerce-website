package com.doan2.spring.service.revenue;

import com.doan2.spring.dao.revenue.RevenueLogDAO;
import com.doan2.spring.entity.RevenueLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RevenueLogServiceImpl implements RevenueLogService{
    @Autowired
    RevenueLogDAO revenueLogDAO;
    @Override
    public List<RevenueLog> getRevenues() {
        return revenueLogDAO.getRevenues();
    }

    @Override
    public void saveRevenueLog(RevenueLog revenueLog) {
        revenueLogDAO.saveRevenueLog(revenueLog);
    }

    @Override
    public RevenueLog getRevenueLog(int idLog) {
        return revenueLogDAO.getRevenueLog(idLog);
    }

    @Override
    public void deleteRevenueLog(int idLog) {
        revenueLogDAO.deleteRevenueLog(idLog);
    }

    @Override
    public List<RevenueLog> getRevenueLogByCustomerId(int idCus) {
        return revenueLogDAO.getRevenueLogByCustomerId(idCus);
    }

    @Override
    public void saveListRevenueLogs(List<RevenueLog> revenueLogList) {
        revenueLogDAO.saveListRevenueLogs(revenueLogList);
    }

    @Override
    public List<RevenueLog> getRevenueLogByMonth(int month) {
        return revenueLogDAO.getRevenueLogByMonth(month);
    }
}
