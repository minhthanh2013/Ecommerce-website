package com.doan2.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping("/")
    public String cartHome(){
        return "cart/cart";
    }
    @GetMapping("")
    public String cartHome1(){
        return "cart/cart";
    }
}
