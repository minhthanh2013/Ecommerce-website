package com.doan2.spring.service.tradingpartner;

import com.doan2.spring.dao.tradingpartner.TradingPartnerLogDAO;
import com.doan2.spring.entity.TradingPartnerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class TradingPartnerLogServiceImpl implements TradingPartnerLogService{
    @Autowired
    TradingPartnerLogDAO tradingPartnerLogDAO;
    @Override
    @Transactional
    public List<TradingPartnerLog> getAll() {
        return tradingPartnerLogDAO.getAll();
    }

    @Override
    @Transactional
    public TradingPartnerLog getTradingPartnerLogById(int theId) {
        return tradingPartnerLogDAO.getTradingPartnerLogById(theId);
    }

    @Override
    @Transactional
    public TradingPartnerLog getTradingPartnerLogByIdOrder(int orderId) {
        return tradingPartnerLogDAO.getTradingPartnerLogByIdOrder(orderId);
    }

    @Override
    @Transactional
    public void save(TradingPartnerLog shippingDetail) {
        tradingPartnerLogDAO.save(shippingDetail);
    }

    @Override
    @Transactional
    public void deleteTradingPartnerLog(TradingPartnerLog tradingPartnerLog) {
        tradingPartnerLogDAO.deleteTradingPartnerLog(tradingPartnerLog);
    }

    @Override
    @Transactional
    public void saveListTradingPartnerLog(List<TradingPartnerLog> tradingPartnerLogList) {
        tradingPartnerLogDAO.saveListTradingPartnerLog(tradingPartnerLogList);
    }

    @Override
    @Transactional
    public List<TradingPartnerLog> getAllByIdSup(int idSup) {
        return tradingPartnerLogDAO.getAllByIdSup(idSup);
    }

    @Override
    @Transactional
    public List<Integer> getLatestIdLog() {
        return tradingPartnerLogDAO.getLatestIdLog();
    }
}
