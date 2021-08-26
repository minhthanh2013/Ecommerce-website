package com.doan2.spring.dao.tradingpartner;

import com.doan2.spring.entity.TradingPartner;

import java.util.List;

public interface TradingPartnerDAO {
    List<TradingPartner> getAll();
    TradingPartner getTradingPartnerById(int theId);
    void save(TradingPartner tradingPartner);
    void deleteTradingPartner(TradingPartner tradingPartner);
    void saveListTradingPartner(List<TradingPartner> tradingPartnerList);
    List<Integer> getIdPartnerByName(String name);
}
