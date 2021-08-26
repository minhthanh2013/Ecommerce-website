package com.doan2.spring.controller;

import com.doan2.spring.entity.*;
import com.doan2.spring.entity.supportentity.OrderProductShopkeeper;
import com.doan2.spring.service.cart.CartService;
import com.doan2.spring.service.cungcap.CungCapService;
import com.doan2.spring.service.customer.CustomerService;
import com.doan2.spring.service.order.OrderService;
import com.doan2.spring.service.product.ProductService;
import com.doan2.spring.service.product.ProductTypeService;
import com.doan2.spring.service.shippingcompany.ShippingCompanyService;
import com.doan2.spring.service.shippingcompany.ShippingDetailService;
import com.doan2.spring.service.supplier.SupplierLogService;
import com.doan2.spring.service.supplier.SupplierService;
import com.doan2.spring.service.userrole.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/shopkeeper")
public class ShopkeeperController {

    private SupplierService supplierService;
    private SupplierLogService supplierLogService;
    private CustomerService customerService;
    private UserRoleService userRoleService;
    private ProductTypeService productTypeService;
    private ProductService productService;
    private CungCapService cungCapService;
    private OrderService orderService;
    private CartService cartService;
    private ShippingCompanyService shippingCompanyService;
    private ShippingDetailService shippingDetailService;
    @Autowired
    ShopkeeperController(SupplierLogService a, SupplierService b, CustomerService c, UserRoleService d, ProductTypeService e, ProductService f, CungCapService g, OrderService i, CartService j, ShippingCompanyService companyService, ShippingDetailService detailService){
        supplierService = b;
        supplierLogService = a;
        customerService = c;
        userRoleService = d;
        productTypeService = e;
        productService = f;
        cungCapService = g;
        orderService = i;
        cartService = j;
        shippingCompanyService = companyService;
        shippingDetailService = detailService;
    }
    @GetMapping("/add_product")
    public String addProduct(Model theModel){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        Supplier supplier = supplierService.getAllByPhone(user_phone);
        theModel.addAttribute("supplier_name", supplier.getNameSup());

        theModel.addAttribute("productTypeList" , productTypeService.getAll());
        theModel.addAttribute("productAttribute", new Product());
//        theModel.addAttribute("product_id", productService.getLatestIdProduct() + 1);


        return "shopkeeper/shopkeeper-add-product";
    }
    @PostMapping("/add_product")
    public String processAddProduct(@ModelAttribute("productAttribute") Product product,
                                    @RequestParam String inventory,
                                    BindingResult bindingResult,
                                    Model theModel){
        if (bindingResult.hasErrors()){
            theModel.addAttribute("error", "Fail to add the new product");
            theModel.addAttribute("productAttribute", new Product());
            return "shopkeeper/shopkeeper-add-product";
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        Supplier supplier = supplierService.getAllByPhone(user_phone);


        product.setIdProduct(productService.getLatestIdProduct()+1);
        System.out.println(product);
        productService.save(product);
        CungCap cungCap = new CungCap(product.getIdProduct(),  supplier.getIdSup(), Integer.parseInt(inventory));
        cungCapService.save(cungCap);

        theModel.addAttribute("success","Success add new product!");
        theModel.addAttribute("productAttribute", product);
        return "shopkeeper/shopkeeper-add-product";
    }

    @GetMapping("/")
    public String editProfile(Model theModel){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        Supplier supplier = supplierService.getAllByPhone(user_phone);
        theModel.addAttribute("supplier_name", supplier.getNameSup());
        theModel.addAttribute("supplier_address", supplier.getAddress());
        theModel.addAttribute("supplier_phone", supplier.getPhone());
        theModel.addAttribute("supplier_email", supplier.getEmail());
        theModel.addAttribute("supplier_idSup", supplier.getIdSup());
        theModel.addAttribute("supplier_bankAccount", supplier.getBankAccount());
        theModel.addAttribute("supplierAttribute", new Supplier());
        return "shopkeeper/shopkeeper-edit-profile";
    }
    @PostMapping("/edit_profile")
    public String processEditProfile(@ModelAttribute("supplierAttribute") Supplier supplier,
                                     BindingResult bindingResult,
                                     Model theModel){
        if (bindingResult.hasErrors()){
            theModel.addAttribute("error", "Failed to edit the shop profile!");
            theModel.addAttribute("supplierAttribute", new Supplier());
            return "shopkeeper/shopkeeper-edit-profile";
        }
        theModel.addAttribute("success", "Success edit the profile!");
        supplierService.save(supplier);
        return "shopkeeper/shopkeeper-edit-profile";
    }
    @GetMapping("/order")
    public String order(Model theModel){
        List<OrderProductShopkeeper> orderProductShopkeeperList = new ArrayList<>();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();

        Customer customer = customerService.getCustomerByPhone(user_phone);
        Supplier supplier = supplierService.getAllByPhone(user_phone);
        theModel.addAttribute("supplier_name", supplier.getNameSup());
        List<Order> orderList = orderService.getOrdersByIdSup(supplier.getIdSup());

        for (int i = 0; i < orderList.size(); i++) {

            OrderProductShopkeeper orderProductShopkeeper = new OrderProductShopkeeper();
            int orderId = orderList.get(i).getIdOrder();
            orderProductShopkeeper.setIdOrder(orderList.get(i).getIdOrder());

            List<Product> productList = new ArrayList<>();
            List<Cart>cartList = cartService.getCartsByCustomerOrderId(customer.getIdCus(), orderId);
            for (int j = 0; j < cartList.size(); j++) {
                int idProduct = cartList.get(j).getIdProduct();
                Product product = productService.getProduct(idProduct);
                productList.add(product);
            }
            orderProductShopkeeper.setProductList(productList);
            orderProductShopkeeper.setTotalMoney(BigDecimal.valueOf(orderList.get(i).getTotalMoney()));
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String tempMn = currencyVN.format(orderProductShopkeeper.getTotalMoney());
            orderProductShopkeeper.setVnTotalMoney(tempMn);
            orderProductShopkeeper.setPaymentOption(orderList.get(i).getTranMethod());
            int status = orderList.get(i).getStatus();
            String statusString;
            if (status == 0) statusString = "confirming";
            else if (status == 1) statusString = "shipping";
            else {
                statusString = "complete";
            }
            orderProductShopkeeper.setStatus(statusString);
            ShippingDetail shippingDetail = shippingDetailService.getShippingDetailByIdOrder(orderId);
            ShippingCompany shippingCompany = shippingCompanyService.getShippingCompanyById(shippingDetail.getIdSCompany());
            orderProductShopkeeper.setShippingCompany(shippingCompany);
            orderProductShopkeeperList.add(orderProductShopkeeper);
        }



        theModel.addAttribute("orderProductShopkeeperList", orderProductShopkeeperList);

        return "shopkeeper/shopkeeper-order";
    }
    @PostMapping("/order")
    public String processOrder(@RequestParam String status, @RequestParam int idOrder, Model theModel){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();

        Order order = orderService.getOrder(idOrder);
        int statusInt;
        if (status.equals("confirming")) statusInt = 0;
        else if (status.equals("shipping")) statusInt = 1;
        else {
            statusInt = 2;
        }
        System.out.println(statusInt);
        order.setStatus(statusInt);
        orderService.updateOrder(order);
        return "redirect:order";
    }

    @GetMapping("/sales_statistics")
    public String saleStat(Model theModel
                         ){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Supplier supplier = supplierService.getAllByPhone(user_phone);
        theModel.addAttribute("supplier_name", supplier.getNameSup());
        return "shopkeeper/shopkeeper-sales-statistics";
    }

    @GetMapping("/sales_statistics_chart")
    public String saleStatChart(Model theModel
                                ,@RequestParam String date_select
                                ,@RequestParam String date_select_type
                                ,@RequestParam(required = false) String date_from
                                ,@RequestParam(required = false) String date_to) throws ParseException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Supplier supplier = supplierService.getAllByPhone(user_phone);
        List<Order> orderList = orderService.getOrdersByIdSup(supplier.getIdSup());
        int sum = 0;
        for (int i = 0; i < orderList.size(); i++) {
            sum += orderList.get(i).getTotalMoney();
        }
        Order minOrder = new Order();

        BigInteger[]monthlyRevenue = orderService.get12MonthRevenueByIdSup(supplier.getIdSup());

        List<Integer> listMinMonth = new ArrayList<>();
        List<Integer> listMaxMonth = new ArrayList<>();
        BigInteger min = monthlyRevenue[0];
        for(int i = 0; i<monthlyRevenue.length; i++) {
            int compareValue = min.compareTo(monthlyRevenue[i]);
            if(compareValue==1) {
                min = monthlyRevenue[i];
            }
        }

        BigInteger max = monthlyRevenue[0];
        for(int i = 0; i<monthlyRevenue.length; i++) {
            int compareValue = monthlyRevenue[i].compareTo(max);
            if(compareValue==1) {
                max = monthlyRevenue[i];
            }
        }
        for(int i = 0; i< monthlyRevenue.length; i++) {
            if(monthlyRevenue[i] == min)
                listMinMonth.add(i+1);
            else if(monthlyRevenue[i] == max){
                listMaxMonth.add(i+1);
            }
        }
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String tempMn = currencyVN.format(sum);
        theModel.addAttribute("total",tempMn);
        theModel.addAttribute("highest_month",listMaxMonth );
        theModel.addAttribute("lowest_month", listMinMonth);

        List<String> day = new ArrayList<>();
        List<String> data = new ArrayList<>();
        theModel.addAttribute("supplier_name", supplier.getNameSup());

        if (!date_from.equals("") && !date_to.equals("")){
            java.sql.Date date1 = java.sql.Date.valueOf(date_from);
            java.sql.Date date2 = java.sql.Date.valueOf(date_to);
            if (date1.after(date2)){
                return "redirect:shopkeeper/shopkeeper-sales-statistics";
            }

            for (int i = 0; i < orderList.size(); i++) {
                java.util.Date orderDate = orderList.get(i).getDate();
                System.out.println(orderDate);
                if (orderDate.after(date1) && orderDate.before(date2)) {
                    Calendar c = Calendar.getInstance();
                    c.setTime(date1);
                    int day1 = c.get(Calendar.DAY_OF_MONTH);
                    c.setTime(date2);
                    int day2 = c.get(Calendar.DAY_OF_MONTH);
                    c.setTime(orderList.get(i).getDate());
                    int day3 = c.get(Calendar.DAY_OF_MONTH);

                    for (int j = day1; j < day2; j++) {
                        if (j == day3) {
                            day.add("'"+ orderList.get(i).getDate() +"'");
//                            day.add("'2021/1/1'");
                            data.add(String.valueOf(orderList.get(i).getTotalMoney()));
                        }
                    }

                }
            }

        } else {
            Calendar c = Calendar.getInstance();

            if (date_select_type.equals("day")){
                for (int i = 0; i < orderList.size(); i++) {
                    c.setTime(orderList.get(i).getDate());
                    int tempDay1 = c.get(Calendar.DAY_OF_MONTH);
                    int tempDay2 = Integer.parseInt(date_select);
                    if (tempDay1 == tempDay2){
                        day.add("'"+ tempDay1 +"'");
                        data.add(String.valueOf(orderList.get(i).getTotalMoney()));
                    }
                }
            } else if (date_select_type.equals("month")){
                for (int i = 0; i < orderList.size(); i++) {
                    c.setTime(orderList.get(i).getDate());
                    int tempDay1 = c.get(Calendar.MONTH)+1;
                    System.out.println(orderList.get(i).getDate());
                    System.out.println("320 "+tempDay1);
                    int tempDay2 = Integer.parseInt(date_select);
                    System.out.println(tempDay2);
                    if (tempDay1 == tempDay2){
                        day.add("'"+ tempDay1 +"'");
                        data.add(String.valueOf(orderList.get(i).getTotalMoney()));
                    }
                }
            } else {
                for (int i = 0; i < orderList.size(); i++) {
                    c.setTime(orderList.get(i).getDate());
                    int tempDay1 = c.get(Calendar.YEAR);
                    int tempDay2 = Integer.parseInt(date_select);
                    if (tempDay1 == tempDay2){
                        day.add("'"+ tempDay1 +"'");
                        data.add(String.valueOf(orderList.get(i).getTotalMoney()));
                    }
                }
            }
        }
        Set<String> dayUnique = new HashSet<>(day);
        Set<String> dataUnique = new HashSet<>(data);
        day.clear();
        data.clear();
        day.addAll(dayUnique);
        data.addAll(dataUnique);
        String[]tmpArr = new String[day.size()];
        String[]tmpArr2 = new String[day.size()];
        for (int i = 0; i < tmpArr.length; i++) {
            tmpArr[i] = day.get(i);
            tmpArr2[i] = data.get(i);
        }
        String tmpStr = Arrays.toString(tmpArr);
        String tmpStr2 = Arrays.toString(tmpArr2);
        theModel.addAttribute("listDay", tmpStr);
        theModel.addAttribute("dayData", tmpStr2);

        return "shopkeeper/shopkeeper-sales-statistics-chart";

    }
    @GetMapping("/update_price")
    public String updatePrice(Model theModel){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        Supplier supplier = supplierService.getAllByPhone(user_phone);
        theModel.addAttribute("supplier_name", supplier.getNameSup());
        List<Product> productList = new ArrayList<>();
        theModel.addAttribute("productList", productList);
        List<Integer> idProductList = cungCapService.getAllIdProductByIdSup(supplier.getIdSup());
        List<ProductType> productTypeList = new ArrayList<>();
        for (int i = 0; i < idProductList.size(); i++) {
            Product product = productService.getProduct(idProductList.get(i));
            productList.add(product);
            int type = product.getIdType();
            Optional<ProductType> productType = productTypeService.getById(type);
            productTypeList.add(productType.get());
        }
        theModel.addAttribute("productTypeList", productTypeList);


        theModel.addAttribute("productAttribute1", new Product());
        return "shopkeeper/shopkeeper-update-price";
    }
    @PostMapping("/update_price")
    public String processEditPrice(@ModelAttribute("productAttribute1") Product product,
                                   BindingResult bindingResult,
                                   Model theModel){
        if (bindingResult.hasErrors()){
            theModel.addAttribute("error", "Failed to edit the shop profile!");
            theModel.addAttribute("supplierAttribute", new Supplier());
            return "shopkeeper/shopkeeper-update-price";
        }
        theModel.addAttribute("success", "Success edit the product!");
        String name = productService.getProduct(product.getIdProduct()).getName();
        product.setName(name);
        System.out.println(product.getIdProduct());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getDescription());
        System.out.println(product.getIdType());
        productService.update(product);
        return "shopkeeper/shopkeeper-update-price";
    }

}
