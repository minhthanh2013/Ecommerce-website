package com.doan2.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
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
    public String adminDashboard(){
        return "admin/admin-dashboard";
    }
}
