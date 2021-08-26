package com.doan2.spring.service.tradingpartner;



import com.doan2.spring.entity.TradingPartner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TradingPartnerService {
    List<TradingPartner> getAll();
    TradingPartner getTradingPartnerById(int theId);
    void save(TradingPartner tradingPartner);
    void deleteTradingPartner(TradingPartner tradingPartner);
    void saveListTradingPartner(List<TradingPartner> tradingPartnerList);
    Page<TradingPartner> findByName(String name, Pageable pageable);
    List<Integer> getIdPartnerByName(String name);
}
