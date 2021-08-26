package com.doan2.spring.rest;

import com.doan2.spring.entity.Cart;
import com.doan2.spring.service.cart.CartService;
import com.doan2.spring.service.product.ProductService;
import com.doan2.spring.service.product.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartRestController{
    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;
    @Autowired
    ProductTypeService productTypeService;



    // Delete

    @RequestMapping(value = "/api/cart/carts/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
   // @ResponseBody
    public String deleteCart(@PathVariable("id") int id){
        List<Cart> cartList = cartService.getListCartNotCheckOut(id);
        if (cartList.size() == 0) return "null";
        cartService.deleteAll(cartList);
        return "Success delete";
    }

    
    @RequestMapping(value = "/api/cart/carts/update/{id}", produces = "application/json; charset=UTF-8", method = {RequestMethod.GET, RequestMethod.PUT})
    @ResponseBody
    public String updateCart(@PathVariable Integer id, @RequestParam String amount){
//        System.out.println(id);
//        System.out.println(amount);

        List<Cart> cartList = cartService.getListCartNotCheckOut(id);
        String[] listInts = amount.split(",");
        for (int i = 0; i < cartList.size(); i++) {
            cartList.get(i).setAmount(Integer.parseInt(listInts[i]));
            int itemPrice = cartList.get(i).getPrice();
            cartList.get(i).setTotal_money(itemPrice * cartList.get(i).getAmount());
        }
        cartService.updateListCart(cartList);
        return "Success update";
    }
    @RequestMapping(value = "/api/cart/carts/delete-item/{id}", produces = "application/json; charset=UTF-8", method = {RequestMethod.GET, RequestMethod.DELETE})
    @ResponseBody
    public String deleteCartItem(@PathVariable Integer id){
       // Cart cart = cartService.getCart(id);
        //List<Cart> cartList = cartService.getListCartNotCheckOut(id);
//        for (int i = 0; i < cartList.size(); i++) {
//            cartList.get(i).setAmount(Integer.parseInt(listInts[i]));
//            int itemPrice = cartList.get(i).getPrice();
//            cartList.get(i).setTotal_money(itemPrice * cartList.get(i).getAmount());
//        }
//        cartService.updateListCart(cartList);
        System.out.println(id);
        cartService.deleteCart(id);
        return "Success delete cart item";
    }


}