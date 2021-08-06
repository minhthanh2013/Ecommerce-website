package com.doan2.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping("/add_address")
    public String addAddress(){
        return "dashboard/dash-address-add";
    }
    @GetMapping("/book_address")
    public String bookAddress(){
        return "dashboard/dash-address-book";
    }
    @GetMapping("/edit_address")
    public String editAddress(){
        return "dashboard/dash-address-edit";
    }
    @GetMapping("/make_default_address")
    public String makeDefaultAddress(){
        return "dashboard/dash-address-make-default";
    }
    @GetMapping("/cancellation")
    public String cancellation(){
        return "dashboard/dash-cancellation";
    }
    @GetMapping("/edit_profile")
    public String editProfile(){
        return "dashboard/dash-edit-profile";
    }
    @GetMapping("/manage_order")
    public String manageOrder(){
        return "dashboard/dash-manage-order";
    }
    @GetMapping("/my_order")
    public String myOrder(){
        return "dashboard/dash-my-order";
    }

    @GetMapping("/my_profile")
    public String myProfile(){
        return "dashboard/dash-my-profile";
    }
    @GetMapping("/payment_option")
    public String paymentOption(){
        return "dashboard/dash-payment-option";
    }
    @GetMapping("/track_order")
    public String trackOrder(){
        return "dashboard/dash-track-order";
    }
    @GetMapping("/")
    public String dashboard(){
        return "dashboard/dashboard";
    }

}
