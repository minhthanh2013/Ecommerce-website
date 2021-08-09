package com.doan2.spring.rest;


import com.doan2.spring.entity.RevenueLog;
import com.doan2.spring.service.revenue.RevenueLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
    @Autowired
    private RevenueLogService revenueLogService;
    @RequestMapping(value = "/revenues", method = RequestMethod.GET, produces = "application/json")
    public List<RevenueLog> getRevenueLog(){
        return revenueLogService.getRevenues();
    }

}
