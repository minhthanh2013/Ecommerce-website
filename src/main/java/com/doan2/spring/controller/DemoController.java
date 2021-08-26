package com.doan2.spring.controller;


import com.doan2.spring.entity.Cart;
import com.doan2.spring.entity.Customer;
import com.doan2.spring.entity.Order;
import com.doan2.spring.entity.Product;
import com.doan2.spring.entity.supportentity.CartProduct;
import com.doan2.spring.service.cart.CartService;
import com.doan2.spring.service.customer.CustomerService;
import com.doan2.spring.service.order.OrderService;
import com.doan2.spring.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Controller
public class DemoController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @GetMapping("/")
    public String showHome(Model theModel){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken){
            productHomeAttribute(theModel);
        }else {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String user_phone = ((UserDetails)principal).getUsername();
            Customer customer = customerService.getCustomerByPhone(user_phone);
            productHomeAttribute(theModel);
            miniCart(theModel, customer);
        }
        return "index";

    }

    public void productHomeAttribute(Model theModel) {
        List<Product> listManCloth = productService.getListProductByType(10);
        theModel.addAttribute("listManCloth", listManCloth);
        List<Product> listWomenCloth = productService.getListProductByType(11);
        theModel.addAttribute("listWomenCloth", listWomenCloth);
        List<Product> listGame = productService.getListProductByType(9);
        theModel.addAttribute("listGame", listGame);
        List<Product> listElectronics = productService.getListProductByType(7);
        theModel.addAttribute("listElectronics", listElectronics);
        List<Cart> cartList = cartService.getLastTwoCarts();

        List<Product> lastTwoOrderProduct = new ArrayList<>();
        for (int i = 0; i < cartList.size(); i++) {
            if (i == 1) {
                if (lastTwoOrderProduct.get(0).getIdProduct() == cartList.get(i).getIdProduct()){
                    break;
                }
            }
            Product product = productService.getProduct(cartList.get(i).getIdProduct());
            lastTwoOrderProduct.add(product);
        }
        theModel.addAttribute("listTwoProducts", lastTwoOrderProduct);
        theModel.addAttribute("listNewArrival", productService.newArrival(6));
        theModel.addAttribute("listTop3", productService.newArrival(3));
    }

    // add request mapping for /leaders
    public void miniCart(Model theModel, Customer customer){
        List<Cart> cartList = cartService.getListCartNotCheckOut(customer.getIdCus());
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        int sum = 0;
        List<CartProduct> cartProductList = new ArrayList<>();
        for (int i = 0; i < cartList.size(); i++) {
            Product product = productService.getProduct(cartList.get(i).getIdProduct());
            CartProduct cartProduct = new CartProduct(cartList.get(i).getAmount(),product.getName(), cartList.get(i).getTotal_money());
            sum += cartList.get(i).getTotal_money();

            String temp = currencyVN.format(cartProduct.getTotal_money());
            cartProduct.setVnTotalMoney(temp);

            cartProductList.add(cartProduct);
        }
        theModel.addAttribute("total_amount", cartList.size());
        String temp = currencyVN.format(sum);
        theModel.addAttribute("cart_product_total", temp);
        theModel.addAttribute("cart_product_list", cartProductList);

        List<Order> orderList = orderService.getOrderByCustomerId(customer.getIdCus());
        theModel.addAttribute("order_list", orderList);
    }
}
