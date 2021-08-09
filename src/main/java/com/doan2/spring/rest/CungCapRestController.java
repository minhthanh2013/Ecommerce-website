package com.doan2.spring.rest;

import com.doan2.spring.entity.CungCap;

import com.doan2.spring.service.cungcap.CungCapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cungcap")
public class CungCapRestController {
    @Autowired
    private CungCapService cungCapService;

    // Add mapping for GET /customers
    @RequestMapping(value = "/cungcaps", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CungCap> getCungCaps(){

        return cungCapService.getAll();
    }
    @RequestMapping(value = "/cungcaps/{productId}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public  CungCap getCungCap(@PathVariable int productId){
        return cungCapService.getByIdProduct(productId);
        // return productService.getProduct(productId);
    }
}
