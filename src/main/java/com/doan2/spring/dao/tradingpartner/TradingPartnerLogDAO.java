package com.doan2.spring.dao.tradingpartner;

import com.doan2.spring.entity.TradingPartnerLog;

import java.util.List;

public interface TradingPartnerLogDAO {
    List<TradingPartnerLog> getAll();
    TradingPartnerLog getTradingPartnerLogById(int theId);
    TradingPartnerLog getTradingPartnerLogByIdOrder(int orderId);
    void save(TradingPartnerLog shippingDetail);
    void deleteTradingPartnerLog(TradingPartnerLog tradingPartnerLog);
    void saveListTradingPartnerLog(List<TradingPartnerLog> tradingPartnerLogList);

    List<TradingPartnerLog> getAllByIdSup(int idSup);
    List<Integer> getLatestIdLog();
}
