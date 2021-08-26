package com.doan2.spring.rest;

import com.doan2.spring.entity.Product;
import com.doan2.spring.entity.ProductType;
import com.doan2.spring.service.product.ProductService;
import com.doan2.spring.service.product.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    // Add mapping for GET /customers
    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Product> getProducts() {

        return productService.getAll();
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Product getProduct(@PathVariable int productId) {
        return productService.getProduct(productId);
        // return productService.getProduct(productId);
    }

    @RequestMapping(value = "/products-by-type", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public Page<Product> getProductsByType(@RequestParam Optional<String> type,
                                           @RequestParam Optional<Integer> page,
                                           @RequestParam Optional<Integer> size) {


        return productService.findAllByType(Integer.parseInt(type.orElse("1")), new PageRequest(
                page.orElse(0), size.orElse(8)
        ));


    }

    @RequestMapping(value = "/products-by-name", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public Page<Product> getProductsByName(@RequestParam Optional<Integer> page,
                                           @RequestParam Optional<String> name,
                                           @RequestParam Optional<Integer> size) {


        return productService.findAllByName(name.orElse("_"), new PageRequest(
                page.orElse(0), size.orElse(8)
        ));


    }
}
