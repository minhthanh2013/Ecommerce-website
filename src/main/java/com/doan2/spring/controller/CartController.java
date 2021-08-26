package com.doan2.spring.controller;

import com.doan2.spring.entity.*;
import com.doan2.spring.entity.supportentity.CartProduct;
import com.doan2.spring.service.cart.CartService;
import com.doan2.spring.service.customer.CustomerService;
import com.doan2.spring.service.order.OrderService;
import com.doan2.spring.service.product.ProductService;
import com.doan2.spring.service.product.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private OrderService orderService;
    @GetMapping("/")
    public String cartHome(Model theModel){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        miniCart(theModel, customer);
        theModel.addAttribute("idCus", customer.getIdCus());
        List<Cart> listCartNotCheckOut = cartService.getListCartNotCheckOut(customer.getIdCus());
        List<CartProduct> cartProductList = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < listCartNotCheckOut.size(); i++) {
            int idProduct = listCartNotCheckOut.get(i).getIdProduct();
            Product product =  productService.getProduct(idProduct);
            int idType = product.getIdType();
            Optional<ProductType> productType = productTypeService.getById(idType);
            CartProduct cartProduct = new CartProduct();
            cartProduct.setIdCart(listCartNotCheckOut.get(i).getId());
            cartProduct.setType(productType.get().getNameType());
            cartProduct.setName(product.getName());
            cartProduct.setAmount(listCartNotCheckOut.get(i).getAmount());
            cartProduct.setTotal_money(listCartNotCheckOut.get(i).getTotal_money());
            String temp = currencyVN.format(listCartNotCheckOut.get(i).getTotal_money());
            cartProduct.setVnTotalMoney(temp);
            cartProductList.add(cartProduct);
            sum += cartProduct.getTotal_money();
        }
        String temp = currencyVN.format(sum);
        theModel.addAttribute("total_money", temp);
        theModel.addAttribute("cartProductList", cartProductList);
        return "cart/cart";
    }
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
            cartProduct.setIdProduct(product.getIdProduct());
            Optional<ProductType> productType = productTypeService.getById(product.getIdType());
            cartProduct.setType(productType.get().getNameType());
            String temp = currencyVN.format(cartList.get(i).getTotal_money());
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
