package com.doan2.spring.rest;

import com.doan2.spring.entity.Cart;
import com.doan2.spring.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartRestController {

    @Autowired
    private CartService cartService;

    // Add mapping for GET /customers
    @RequestMapping(value = "/carts", method = RequestMethod.GET, produces = "application/json")
    public  List<Cart> getCarts(){

        return cartService.getCarts();
    }
}
