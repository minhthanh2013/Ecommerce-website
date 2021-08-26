package com.doan2.spring.rest;

import com.doan2.spring.entity.Order;
import com.doan2.spring.entity.ShippingCompany;
import com.doan2.spring.entity.ShippingDetail;
import com.doan2.spring.service.order.OrderService;
import com.doan2.spring.service.shippingcompany.ShippingCompanyService;
import com.doan2.spring.service.shippingcompany.ShippingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @Autowired
    ShippingDetailService shippingDetailService;

    @GetMapping("/orders")
    public Page<Order> getAllWithPages(@RequestParam Optional<Integer> idOrder,
                                       @RequestParam Optional<Integer> page) {
        return orderService.findByIdOrder(idOrder.orElse(1), new PageRequest(
                page.orElse(0), 5
        ));
    }

    @GetMapping("/orders-by-options")
    public Page<Order> getAllWithPagesAndOptions(@RequestParam Optional<Integer> page,
                                                 @RequestParam String option,
                                                 @RequestParam String idCus) {
        System.out.println(page.get());
        System.out.println(option);
        System.out.println(idCus);
        if (option.equals("15")) {


            return orderService.findByLastNDay(Integer.parseInt(option), new PageRequest(
                    page.orElse(0), 5
            ), Integer.parseInt(idCus));
        } else if (option.equals("30")) {
            return orderService.findByLastNDay(Integer.parseInt(option), new PageRequest(
                    page.orElse(0), 5
            ), Integer.parseInt(idCus));
        } else if (option.equals("6")) {
            return orderService.findByLastNMonth(Integer.parseInt(option), new PageRequest(
                    page.orElse(0), 5), Integer.parseInt(idCus));
        } else if (option.equals("5")) {
            return orderService.last5Order(new PageRequest(
                    page.orElse(0), 5
            ), Integer.parseInt(idCus));
        } else if (option.equals("2020")) {
            return orderService.findAllByYear(Integer.parseInt(option), new PageRequest(
                    page.orElse(0), 5
            ), Integer.parseInt(idCus));
        } else {
            return orderService.findAllByIdCus(Integer.parseInt(idCus),new PageRequest(
                    page.orElse(0), 5
            ));
        }


    }
//    @GetMapping("/suppliers")
//    public Page<Order> getAllWithPagesByIdSup(@RequestParam Optional<Integer> idSup,
//                                              @RequestParam Optional<Integer> page){
//        return orderService.findByIdSup(idSup.orElse(1), new PageRequest(
//                page.orElse(0), 5
//        ));
//    }
}
