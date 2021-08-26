package com.doan2.spring.controller;

import com.doan2.spring.entity.*;
import com.doan2.spring.entity.supportentity.CartProduct;
import com.doan2.spring.entity.supportentity.ProductTypeCungCap;
import com.doan2.spring.service.cart.CartService;
import com.doan2.spring.service.cungcap.CungCapService;
import com.doan2.spring.service.customer.CustomerService;
import com.doan2.spring.service.order.OrderService;
import com.doan2.spring.service.product.ProductService;
import com.doan2.spring.service.product.ProductTypeService;
import com.doan2.spring.service.shippingfee.ShippingFeeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CungCapService cungCapService;
    private final String PRODUCT_API_URL = "http://localhost:8080/doan2_new_war/api/product/products";
    private final String PRODUCT_BY_TYPE_API_URL = "http://localhost:8080/doan2_new_war/api/product/products-by-type";
    private final String PRODUCT_BY_NAME_API_URL = "http://localhost:8080/doan2_new_war/api/product/products-by-name";
    private final String CUNGCAP_API_URL = "http://localhost:8080/doan2_new_war/api/cungcap/cungcaps";

    @GetMapping("")
    public String product(Model theModel,
                          @RequestParam(required = false, defaultValue = "1") String type,
                          @RequestParam(required = false, defaultValue = "0") String page,
                          @RequestParam(required = false, defaultValue = "8") String size,
                          @RequestParam(required = false) String name) throws IOException, InterruptedException {
        if (SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated() && !(SecurityContextHolder.getContext().getAuthentication()
                instanceof AnonymousAuthenticationToken)) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String user_phone = ((UserDetails) principal).getUsername();
            Customer customer = customerService.getCustomerByPhone(user_phone);
            miniCart(theModel, customer);
        }
        List<ProductType> productTypeList = productTypeService.getAll();
        List<ProductTypeCungCap> productTypeCungCaps = new ArrayList<>();
        for (int i = 0; i < productTypeList.size(); i++) {
            int idType1 = productTypeList.get(i).getIdType();
            int count = productService.countByType(idType1);
            String nameType = productTypeList.get(i).getNameType();
            ProductTypeCungCap productTypeCungCap = new ProductTypeCungCap(idType1, nameType, count);
            productTypeCungCaps.add(productTypeCungCap);
        }
        theModel.addAttribute("productTypeCungCaps", productTypeCungCaps);
        theModel.addAttribute("type1", type);
        HttpResponse<String> response1;
        ObjectMapper mapper1 = new ObjectMapper();
        if (type.equals("1")  && page.equals("0") && size.equals("8") && name != null){
            response1 = getList(PRODUCT_BY_NAME_API_URL, page, name,size, 0);
            JSONObject jsonObject = new JSONObject(response1.body());
            List<Product> productList = mapper1.readValue(jsonObject.get("content").toString(), new TypeReference<List<Product>>() {
            }); // contains dup
            List<ProductType> productTypeList1 = new ArrayList<>(); // list dup list

            for (int i = 0; i < productList.size(); i++) {
                int idType2 = productList.get(i).getIdType();
                Optional<ProductType> productType = productTypeService.getById(idType2);
                productTypeList1.add(productType.get());
            }


            theModel.addAttribute("productTypeList1", productTypeList1);
            theModel.addAttribute("productList", productList);
            List<Integer> integers = new ArrayList<>();
            for (int i = 0; i <= productList.size()/Integer.parseInt(size); i++) {
                integers.add(i);
            }
            theModel.addAttribute("productListSize", integers);
            return "product/product";
        }

//        if (name == null){
        response1 = getList(PRODUCT_BY_TYPE_API_URL, page, type,size, 1);
        System.out.println(response1.body());
        JSONObject jsonObject = new JSONObject(response1.body());
        List<Product> productList = mapper1.readValue(jsonObject.get("content").toString(), new TypeReference<List<Product>>() {
        });
        theModel.addAttribute("productList", productList);
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i <= productList.size()/Integer.parseInt(size); i++) {
            integers.add(i);
        }
        theModel.addAttribute("productListSize", integers);
//        }
//        else{
//            response1 = getList(PRODUCT_BY_NAME_API_URL, page, name, 0);
//            JSONObject jsonObject = new JSONObject(response1.body());
//            System.out.println(jsonObject.get("content"));
//            List<Product> productList = mapper1.readValue(jsonObject.get("content").toString(), new TypeReference< List<Product>>() {
//            });
//            theModel.addAttribute("productList", productList);
//            theModel.addAttribute("productListSize", productList.size());
//        }

        return "product/product";
    }

    @GetMapping("/product_detail")
    public String productDetail(@RequestParam String id, Model theModel) throws IOException, InterruptedException {

        if (id != null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (SecurityContextHolder.getContext().getAuthentication() != null &&
                    SecurityContextHolder.getContext().getAuthentication().isAuthenticated() && !(SecurityContextHolder.getContext().getAuthentication()
                    instanceof AnonymousAuthenticationToken)) {
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                String user_phone = ((UserDetails) principal).getUsername();
                Customer customer = customerService.getCustomerByPhone(user_phone);
                miniCart(theModel, customer);
            }

            //String processedURI = PRODUCT_API_URL + "/" + id;
            //String processedURI = "http://localhost:8080/doan2_new_war/api/product/products/1";
//            String processedURI = "https://jsonplaceholder.typicode.com/posts/1";
            HttpResponse<String> response = getListProducts(PRODUCT_API_URL, id);
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            List<Product> product = mapper.readValue(response.body(), new TypeReference<List<Product>>() {
            });

            theModel.addAttribute("product", product.get(0));

//
            HttpResponse<String> response1 = getListProducts(CUNGCAP_API_URL, id);
            ObjectMapper mapper1 = new ObjectMapper();
            mapper1.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            System.out.println(response1.body());
            List<CungCap> cungCaps = mapper1.readValue(response1.body(), new TypeReference<List<CungCap>>() {
            });
            theModel.addAttribute("cungcap", cungCaps.get(0));
            theModel.addAttribute("cartAttribute", new Cart());

        }
        return "product/product-detail-variable";


    }

    @PostMapping("/post")
    public String postProduct(@ModelAttribute("cartAttribute") Cart cart) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails) principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);

        cart.setId(cartService.getLatestIdCart().get(0) + 1);
        cart.setIdOrder(null);
        Product product = productService.getProduct(cart.getIdProduct());
        cart.setPrice(product.getPrice());
        cart.setTotal_money(product.getPrice() * cart.getAmount());
        cart.setIdCus(customer.getIdCus());
        System.out.println("86 " + cart.getIdProduct());
        System.out.println("87 " + cart.getAmount());
        System.out.println(cart);
        cartService.saveCart(cart);
        return "redirect:/product/product_detail?id=" + cart.getIdProduct();
    }

    public HttpResponse<String> getListProducts(String url, String id) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String temp = url + "/" + id;
        URI uri = URI.create(temp);
        System.out.println(temp);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .header("accept", "application/json;charset=utf-8")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }

    public void miniCart(Model theModel, Customer customer) {
        List<Cart> cartList = cartService.getListCartNotCheckOut(customer.getIdCus());
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        int sum = 0;
        List<CartProduct> cartProductList = new ArrayList<>();
        for (int i = 0; i < cartList.size(); i++) {
            Product product = productService.getProduct(cartList.get(i).getIdProduct());
            CartProduct cartProduct = new CartProduct(cartList.get(i).getAmount(), product.getName(), cartList.get(i).getTotal_money());
            sum += cartList.get(i).getTotal_money();
            String temp = currencyVN.format(cartProduct.getTotal_money());
            cartProduct.setVnTotalMoney(temp);
            cartProductList.add(cartProduct);

        }
        String temp = currencyVN.format(sum);
        theModel.addAttribute("cart_product_total", temp);
        theModel.addAttribute("cart_product_list", cartProductList);
        theModel.addAttribute("total_amount", cartList.size());
        List<Order> orderList = orderService.getOrderByCustomerId(customer.getIdCus());
        theModel.addAttribute("order_list", orderList);
    }

    public HttpResponse<String> getList(String url, String page, String tempStr, String size, int isPage) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        //String newString = url+
        System.out.println(tempStr);
        String temp = null;
        if (isPage == 0) {
            temp = url + "?page=" + URLEncoder.encode(page) + "&name=" + URLEncoder.encode(tempStr)+ "&size=" + URLEncoder.encode(size);

        } else if (isPage == 1) {
            temp = url + "?page=" + URLEncoder.encode(page) + "&type=" + URLEncoder.encode(tempStr)+ "&size=" + URLEncoder.encode(size);

        }
        System.out.println(temp);
        URI uri = URI.create(temp);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .header("accept", "application/json;charset=utf-8")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }
}
