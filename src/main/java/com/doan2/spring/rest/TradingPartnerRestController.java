package com.doan2.spring.rest;

import com.doan2.spring.entity.TradingPartner;
import com.doan2.spring.service.tradingpartner.TradingPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/partner")
public class TradingPartnerRestController {
    @Autowired
    TradingPartnerService tradingPartnerService;
    @GetMapping("/partners")
    public Page<TradingPartner> getAllWithPages(@RequestParam Optional<String> name,
                                                @RequestParam Optional<Integer> page
                                                ) {

        return tradingPartnerService.findByName(name.orElse("_"), new PageRequest(
                page.orElse(0), 5
        ));
    }
}
