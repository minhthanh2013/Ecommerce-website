package com.doan2.spring.service.tradingpartner;

import com.doan2.spring.dao.tradingpartner.TradingPartnerDAO;
import com.doan2.spring.entity.TradingPartner;
import com.doan2.spring.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class TradingPartnerServiceImpl implements TradingPartnerService{
    @Autowired
    TradingPartnerDAO tradingPartnerDAO;
    @Autowired
    PartnerRepository partnerRepository;
    @Override
    @Transactional
    public List<TradingPartner> getAll() {
        return tradingPartnerDAO.getAll();
    }

    @Override
    @Transactional
    public TradingPartner getTradingPartnerById(int theId) {
        return tradingPartnerDAO.getTradingPartnerById(theId);
    }

    @Override
    @Transactional
    public void save(TradingPartner tradingPartner) {
        tradingPartnerDAO.save(tradingPartner);
    }

    @Override
    @Transactional
    public void deleteTradingPartner(TradingPartner tradingPartner) {
        tradingPartnerDAO.deleteTradingPartner(tradingPartner);
    }

    @Override
    @Transactional
    public void saveListTradingPartner(List<TradingPartner> tradingPartnerList) {
        tradingPartnerDAO.saveListTradingPartner(tradingPartnerList);
    }

    @Override
    @Transactional
    public Page<TradingPartner> findByName(String name, Pageable pageable) {
        return partnerRepository.findByName(name, pageable);
    }

    @Override
    @Transactional
    public  List<Integer> getIdPartnerByName(String name) {
        return tradingPartnerDAO.getIdPartnerByName(name);
    }
}
