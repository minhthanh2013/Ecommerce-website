package com.doan2.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopkeeper")
public class ShopkeeperController {

    @GetMapping("/add_product")
    public String addProduct(){
        return "shopkeeper/shopkeeper-add-product";
    }
    @GetMapping("/add_promotion")
    public String addPromotion(){
        return "shopkeeper/shopkeeper-add-promotion";
    }
    @GetMapping("/edit_profile")
    public String editProfile(){
        return "shopkeeper/shopkeeper-edit-profile";
    }
    @GetMapping("/order")
    public String order(){
        return "shopkeeper/shopkeeper-order";
    }
    @GetMapping("/sales_diary")
    public String saleDiary(){
        return "shopkeeper/shopkeeper-sales-diary";
    }
    @GetMapping("/sales_statistics")
    public String saleStat(){
        return "shopkeeper/shopkeeper-sales-statistics";
    }
    @GetMapping("/sales_statistics_chart")
    public String saleStatChart(){
        return "shopkeeper/shopkeeper-sales-statistics-chart";
    }
    @GetMapping("/update_price")
    public String updatePrice(){
        return "shopkeeper/shopkeeper-update-price";
    }

}
