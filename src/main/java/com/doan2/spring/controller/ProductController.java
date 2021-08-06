package com.doan2.spring.controller;

import com.doan2.spring.entity.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final String PRODUCT_API_URL = "http://localhost:8080/doan2_new_war/api/product/products";
    @GetMapping("/product_detail")
    public String productDetail(@RequestParam(required = false) String id, Model theModel) throws IOException, InterruptedException {

        if (id != null) {

            //String processedURI = PRODUCT_API_URL + "/" + id;
            //String processedURI = "http://localhost:8080/doan2_new_war/api/product/products/1";
//            String processedURI = "https://jsonplaceholder.typicode.com/posts/1";
            HttpClient client = HttpClient.newHttpClient();
            String temp = PRODUCT_API_URL+"?id="+id;
            URI uri = URI.create(temp);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .header("accept", "application/json;charset=utf-8")
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            System.out.println("Status code: "+ response.statusCode());
            System.out.println("Body: "+response.body());
            System.out.println(response.headers());
            ObjectMapper mapper = new ObjectMapper();
            List<Product> product = mapper.readValue(response.body(), new TypeReference< List<Product>>() {
            });
            theModel.addAttribute("product", product.get(0));

        }
        return "product/product-detail-variable";


    }
}
