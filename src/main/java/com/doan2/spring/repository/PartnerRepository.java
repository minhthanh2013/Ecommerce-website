package com.doan2.spring.repository;


import com.doan2.spring.entity.TradingPartner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("partnerRepository")
public interface PartnerRepository extends JpaRepository<TradingPartner, Integer> {
    @Query("select s from TradingPartner s where s.namePartner like %?1%")
    Page<TradingPartner> findByName(String name, Pageable pageable);
}
