package com.doan2.spring.service.tradingpartner;

import com.doan2.spring.entity.ShippingDetail;
import com.doan2.spring.entity.TradingPartnerLog;

import java.util.List;

public interface TradingPartnerLogService {
    List<TradingPartnerLog> getAll();
    TradingPartnerLog getTradingPartnerLogById(int theId);
    TradingPartnerLog getTradingPartnerLogByIdOrder(int orderId);
    void save(TradingPartnerLog shippingDetail);
    void deleteTradingPartnerLog(TradingPartnerLog tradingPartnerLog);
    void saveListTradingPartnerLog(List<TradingPartnerLog> tradingPartnerLogList);
    List<TradingPartnerLog> getAllByIdSup(int idSup);
    List<Integer> getLatestIdLog();
}
