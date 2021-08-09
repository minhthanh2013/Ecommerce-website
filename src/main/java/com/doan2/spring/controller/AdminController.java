package com.doan2.spring.controller;

import com.doan2.spring.entity.RevenueLog;
import com.doan2.spring.service.revenue.RevenueLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    RevenueLogService revenueLogService;
    @RequestMapping("/users")
    public String adminUser(){
        return "admin/admin-users";
    }
    @RequestMapping("/track-shop-order")
    public String adminTrackOrder(){
        return "admin/admin-track-shop-order";
    }
    @RequestMapping("/suppliers")
    public String adminSupplier(){
        return "admin/admin-suppliers";
    }
    @RequestMapping("/shipping-company")
    public String adminShippingCompany(){
        return "admin/admin-shipping-company";
    }
    @RequestMapping("/partners")
    public String adminPartner(){
        return "admin/admin-partners";
    }
    @RequestMapping("/")
    public String adminDashboard(Model theModel){
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
        List<RevenueLog> revenueLogListThisMonth = revenueLogService.getRevenueLogByMonth(currentMonth);
        int sum = 0;
        for (int i = 0; i < revenueLogListThisMonth.size(); i++) {
            sum += revenueLogListThisMonth.get(i).getTotal_money();
        }
        int sum1 = 0;
        List<RevenueLog> revenueLogList = revenueLogService.getRevenues();
        for (int i = 0; i < revenueLogList.size(); i++) {
            sum1 += revenueLogList.get(i).getTotal_money();
        }

        theModel.addAttribute("revenue_this_month", sum);
        theModel.addAttribute("revenue_total", sum1);

        return "admin/admin-dashboard";
    }
}
