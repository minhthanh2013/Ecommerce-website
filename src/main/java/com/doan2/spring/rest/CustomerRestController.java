package com.doan2.spring.rest;

import com.doan2.spring.entity.Customer;
import com.doan2.spring.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/customers")
    public Page<Customer> getAllWithPages(@RequestParam Optional<String> name,
                                          @RequestParam Optional<Integer> page
    ) {

        return customerService.findByName(name.orElse("_"), new PageRequest(
                page.orElse(0), 5
        ));
    }
}
