package com.doan2.spring.dao.revenue;

import com.doan2.spring.entity.RevenueLog;

import java.util.List;

public interface RevenueLogDAO {
    List<RevenueLog> getRevenues();

    void saveRevenueLog(RevenueLog revenueLog);

    RevenueLog getRevenueLog(int idLog);

    void deleteRevenueLog(int idLog);

    List<RevenueLog> getRevenueLogByCustomerId(int idCus);

    void saveListRevenueLogs(List<RevenueLog> revenueLogList);
    List<RevenueLog> getRevenueLogByMonth( int month);
}
