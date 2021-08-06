package com.doan2.spring.rest;

import com.doan2.spring.entity.Product;
import com.doan2.spring.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    // Add mapping for GET /customers
    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public  List<Product> getProducts(){

        return productService.getAll();
    }
    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public  Product getProduct(@PathVariable int productId){
       return productService.getProduct(productId);
       // return productService.getProduct(productId);
    }
}
