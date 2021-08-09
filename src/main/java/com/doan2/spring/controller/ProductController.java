package com.doan2.spring.controller;

import com.doan2.spring.entity.*;
import com.doan2.spring.entity.supportentity.CartProduct;
import com.doan2.spring.service.cart.CartService;
import com.doan2.spring.service.customer.CustomerService;
import com.doan2.spring.service.order.OrderService;
import com.doan2.spring.service.product.ProductService;
import com.doan2.spring.service.shippingfee.ShippingFeeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ShippingFeeService shippingFeeService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    private final String PRODUCT_API_URL = "http://localhost:8080/doan2_new_war/api/product/products";
    private final String CUNGCAP_API_URL = "http://localhost:8080/doan2_new_war/api/cungcap/cungcaps";
    @GetMapping("/product_detail")
    public String productDetail(@RequestParam(required = false) String id, Model theModel) throws IOException, InterruptedException {

        if (id != null) {
            if (SecurityContextHolder.getContext().getAuthentication() != null &&
                    SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&  !(SecurityContextHolder.getContext().getAuthentication()
                    instanceof AnonymousAuthenticationToken)) {
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                String user_phone = ((UserDetails)principal).getUsername();
                Customer customer = customerService.getCustomerByPhone(user_phone);
                miniCart(theModel, customer);
            }

            //String processedURI = PRODUCT_API_URL + "/" + id;
            //String processedURI = "http://localhost:8080/doan2_new_war/api/product/products/1";
//            String processedURI = "https://jsonplaceholder.typicode.com/posts/1";
            HttpResponse<String> response = getListProducts(PRODUCT_API_URL, id);
            ObjectMapper mapper = new ObjectMapper();
            List<Product> product = mapper.readValue(response.body(), new TypeReference< List<Product>>() {
            });
            theModel.addAttribute("product", product.get(0));

//
            HttpResponse<String> response1 = getListProducts(CUNGCAP_API_URL, id);
            ObjectMapper mapper1 = new ObjectMapper();
            List<CungCap> cungCaps = mapper1.readValue(response1.body(), new TypeReference< List<CungCap>>() {
            });
            theModel.addAttribute("cungcap", cungCaps.get(0));

        }
        return "product/product-detail-variable";



    }

    public HttpResponse<String> getListProducts(String url, String id) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String temp = url+"?id="+id;
        URI uri = URI.create(temp);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .header("accept", "application/json;charset=utf-8")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }
    public void miniCart(Model theModel, Customer customer){
        List<Cart> cartList = cartService.getListCartNotCheckOut(customer.getIdCus());
        int sum = 0;
        List<CartProduct> cartProductList = new ArrayList<>();
        for (int i = 0; i < cartList.size(); i++) {
            Product product = productService.getProduct(cartList.get(i).getIdProduct());
            CartProduct cartProduct = new CartProduct(cartList.get(i).getAmount(),product.getName(), cartList.get(i).getTotal_money());
            sum += cartList.get(i).getTotal_money();
            cartProductList.add(cartProduct);
        }
        theModel.addAttribute("cart_product_total", sum);
        theModel.addAttribute("cart_product_list", cartProductList);

        List<Order> orderList = orderService.getOrderByCustomerId(customer.getIdCus());
        theModel.addAttribute("order_list", orderList);
    }
}
