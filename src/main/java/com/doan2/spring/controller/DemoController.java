package com.doan2.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class DemoController {
    
    @GetMapping("/")
    public String showHome(){

        return "index";
    }
    // add request mapping for /leaders

}
