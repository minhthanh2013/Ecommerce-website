package com.doan2.spring.controller;

import com.doan2.spring.entity.*;
import com.doan2.spring.entity.supportentity.CartProduct;
import com.doan2.spring.entity.supportentity.EditUser;
import com.doan2.spring.entity.supportentity.OrderProduct;
import com.doan2.spring.entity.supportentity.UserEditAddress;
import com.doan2.spring.service.cart.CartService;
import com.doan2.spring.service.order.OrderService;
import com.doan2.spring.service.customer.CustomerService;
import com.doan2.spring.service.product.ProductService;
import com.doan2.spring.service.shippingfee.ShippingFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    private final String[] districtList = {"0","District 1","District 2","District 3"
            ,"District 4","District 5","District 6","District 7"
            ,"District 8","District 9","District 10","District 11"
            ,"District 12", "Binh Tan District", "Binh Thanh District","Go Vap District"
            ,"Phu Nhuan District", "Tan Binh District", "Tan Phu District", "Thu Duc District","Binh Chanh District","Can Gio District",
            "Cu Chi District", "District Hoc Mon", "District Nha Ba"};
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


    @GetMapping("/book_address")
    public String bookAddress(Model theModel){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        miniCart(theModel, customer);
        theModel.addAttribute("user_full_name", customer.getNameCus());
        theModel.addAttribute("user_address", customer.getAddress());
        theModel.addAttribute("user_phone", customer.getPhone());
        return "dashboard/dash-address-book";
    }
    @GetMapping("/edit_address")
    public String editAddress(Model theModel){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        theModel.addAttribute("user_full_name", customer.getNameCus());
        miniCart(theModel, customer);

        String[]nameSplit = customer.getNameCus().split(" ");
        UserEditAddress userEditAddress = new UserEditAddress(nameSplit[0], nameSplit[nameSplit.length-1], customer.getPhone(), customer.getAddress()
                , "Viet Nam", "Ho Chi Minh City", "5");

        theModel.addAttribute("userEditAddress", userEditAddress);
        return "dashboard/dash-address-edit";
    }
    @PostMapping("/processEditAddress")
    public String processEditAddress(@ModelAttribute("userEditAddress") UserEditAddress userEditAddress, BindingResult theBindingResult, Model theModel){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        if (userEditAddress.getProvince().equals("hcm")) userEditAddress.setProvince("Ho Chi Minh");
        String fullAddress = userEditAddress.getAddress() +", "+districtList[Integer.parseInt(userEditAddress.getDistrict())]+", "
                +userEditAddress.getProvince()+", "+userEditAddress.getCountry();
        customer.setAddress(fullAddress);
        List<Order> orderList = orderService.getOrderByCustomerId(customer.getIdCus());
        for (int i = 0; i < orderList.size(); i++) {
            orderList.get(i).setDeliveryAddress(customer.getAddress());
        }

        theModel.addAttribute("userEditAddress1", userEditAddress);
        customerService.saveCustomer(customer);
        orderService.saveListOrders(orderList);
        return "redirect/redirectEditAddress";
    }





    @GetMapping("/make_default_address")
    public String makeDefaultAddress(){
        return "dashboard/dash-address-make-default";
    }
    @GetMapping("/cancellation")
    public String cancellation(){
        return "dashboard/dash-cancellation";
    }

    @GetMapping("/edit_profile")
    public String editProfile(Model theModel){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        miniCart(theModel, customer);
        String[]split = customer.getNameCus().split(" ");
        theModel.addAttribute("user_full_name", customer.getNameCus());
        theModel.addAttribute("user_last_name", split[split.length-1]);
        theModel.addAttribute("user_first_name", split[0]);
        theModel.addAttribute("user_email", customer.getEmail());
//        String firstName, String lastName, Date dateOfBirth, int gender, String email

        EditUser editUser = new EditUser(split[0], split[split.length-1], customer.getDob(), customer.getSex(), customer.getEmail());
        theModel.addAttribute("editUser", editUser);
        return "dashboard/dash-edit-profile";
    }
    @PostMapping("/process_edit_profile")
    public String editProfilePost(@ModelAttribute("editUser") EditUser editUser, BindingResult theBindingResult, Model theModel){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        String fullName = editUser.getFirstName() +" "+editUser.getLastName();

        if (theBindingResult.hasErrors()){
            return "dashboard/dash-edit-profile";
        }

        customer.setNameCus(fullName);
        customer.setDob(editUser.getDateOfBirth());
        customer.setSex(editUser.getGender());
        if (customerService.checkExistedEmail(editUser.getEmail(), customer.getIdCus())){
            String[]split = customer.getNameCus().split(" ");
            theModel.addAttribute("editUser", new EditUser(split[0], split[split.length-1], customer.getDob(), customer.getSex(), customer.getEmail()));
            theModel.addAttribute("registrationError", "Email already exists.");
            return "dashboard/dash-edit-profile";
        }
        customer.setEmail(editUser.getEmail());

        theModel.addAttribute("Customer" , customer);
        miniCart(theModel, customer);
        customerService.saveCustomer(customer);
        return "redirect/redirectEditProfile";
    }

    @GetMapping("/manage_order?idOrder={idOrder}&email={email}")
    public String manageOrderTwoParams(@PathVariable Integer idOrder, Model theModel, @PathVariable String email) throws ParseException {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        miniCart(theModel, customer);
        if (!customer.getEmail().equals(email)){
            theModel.addAttribute("err", "No order match your email!");
            return "dashboard/dash-track-order";
        }


            Order order = orderService.getOrder(idOrder);
            Date fullDate = order.getDate();
            String fullDateString = String.valueOf(fullDate);
            String[] date = fullDateString.split("-");
            String day = date[2];
            String month = date[1];
            String year = date[0];
            theModel.addAttribute("day", day);
            int intMonth = Integer.parseInt(month);
            String monthString = new DateFormatSymbols().getInstance(Locale.ENGLISH).getMonths()[intMonth-1];
            theModel.addAttribute("month", monthString);
            theModel.addAttribute("year", year);




            System.out.println(order);
            ShippingFee shippingFee = shippingFeeService.getShippingFee(idOrder);
            int shipFee = shippingFee.getShippingFee();
            List<Cart> cartList = cartService.getCartsByCustomerOrderId(customer.getIdCus(), idOrder);
            System.out.println(cartList.get(0));
            //List<Product> productNames = new ArrayList<>();
            List<CartProduct> cartProductList = new ArrayList<>();
            for (int i = 0; i < cartList.size(); i++) {
                Product product = productService.getProduct(cartList.get(i).getIdProduct());
                //productNames.add(product);
                CartProduct cartProduct = new CartProduct(cartList.get(i).getAmount(), product.getName(), cartList.get(i).getTotal_money());
                cartProductList.add(cartProduct);
            }
            int total = order.getTotalMoney() + shipFee;

            theModel.addAttribute("order_id", order.getIdOrder());

            theModel.addAttribute("order_date",order.getDate());

            theModel.addAttribute("order_total_money", order.getTotalMoney());
            //theModel.addAttribute("product_list", productNames);
            theModel.addAttribute("cartList", cartProductList);
            theModel.addAttribute("user_full_name", customer.getNameCus());
            theModel.addAttribute("user_address", customer.getAddress());
            theModel.addAttribute("user_phone", customer.getPhone());
            theModel.addAttribute("shipping_fee", shipFee);
            theModel.addAttribute("total_order_ship_fee", total);

        return "dashboard/dash-manage-order";


    }
    @GetMapping("/manage_order")
    public String manageOrder(@RequestParam(required = false) Integer idOrder, Model theModel) throws ParseException {

            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String user_phone = ((UserDetails)principal).getUsername();
            Customer customer = customerService.getCustomerByPhone(user_phone);
        miniCart(theModel, customer);
            List<Order> orderList = orderService.getOrderByCustomerId(customer.getIdCus());
        System.out.println(idOrder);
            Boolean flag = false;
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getIdOrder() == idOrder){
                    flag = true;
                    break;
                }
            }
            System.out.println(flag);
            if (flag == true){

                Order order = orderService.getOrder(idOrder);
                Date fullDate = order.getDate();
                String fullDateString = String.valueOf(fullDate);
                String[] date = fullDateString.split("-");
                String day = date[2];
                String month = date[1];
                String year = date[0];
                theModel.addAttribute("day", day);
                int intMonth = Integer.parseInt(month);
                String monthString = new DateFormatSymbols().getInstance(Locale.ENGLISH).getMonths()[intMonth-1];
                theModel.addAttribute("month", monthString);
                theModel.addAttribute("year", year);




                System.out.println(order);
                ShippingFee shippingFee = shippingFeeService.getShippingFee(idOrder);
                int shipFee = shippingFee.getShippingFee();
                List<Cart> cartList = cartService.getCartsByCustomerOrderId(customer.getIdCus(), idOrder);
                System.out.println(cartList.get(0));
                //List<Product> productNames = new ArrayList<>();
                List<CartProduct> cartProductList = new ArrayList<>();
                for (int i = 0; i < cartList.size(); i++) {
                    Product product = productService.getProduct(cartList.get(i).getIdProduct());
                    //productNames.add(product);
                    CartProduct cartProduct = new CartProduct(cartList.get(i).getAmount(), product.getName(), cartList.get(i).getTotal_money());
                    cartProductList.add(cartProduct);
                }
                int total = order.getTotalMoney() + shipFee;
                System.out.println(order.getIdOrder());
                theModel.addAttribute("order_id", order.getIdOrder());
                System.out.println(order.getDate());
                theModel.addAttribute("order_date",order.getDate());
                System.out.println(order.getTotalMoney());
                theModel.addAttribute("order_total_money", order.getTotalMoney());
                //theModel.addAttribute("product_list", productNames);
                theModel.addAttribute("cartList", cartProductList);
                theModel.addAttribute("user_full_name", customer.getNameCus());
                theModel.addAttribute("user_address", customer.getAddress());
                theModel.addAttribute("user_phone", customer.getPhone());
                theModel.addAttribute("shipping_fee", shipFee);
                theModel.addAttribute("total_order_ship_fee", total);
                return "dashboard/dash-manage-order";
            }
            return "dashboard/dash-manage-order";


    }
    @GetMapping("/my_order")
    public String myOrder(Model theModel){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        miniCart(theModel, customer);
        theModel.addAttribute("user_full_name", customer.getNameCus());
        List<Order> orderList = orderService.getOrderByCustomerId(customer.getIdCus());
        List<OrderProduct> orderProductList = new ArrayList<>();
        for (int i = 0; i < orderList.size(); i++) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setIdOrder(orderList.get(i).getIdOrder());
            orderProduct.setDate(orderList.get(i).getDate());
            int status = orderList.get(i).getStatus();
            if (status == 0){
                orderProduct.setStatus("Delivered");
            } else if (status == 1) {
                orderProduct.setStatus("Shipping");
            } else {
                orderProduct.setStatus("Confirming");
            }
            orderProduct.setTotalMoney(orderList.get(i).getTotalMoney());
            List<Cart> cartList = cartService.getCartsByCustomerOrderId(customer.getIdCus(), orderList.get(i).getIdOrder());
            for (int j = 0; j < cartList.size(); j++) {
                Product product = productService.getProduct(cartList.get(j).getIdProduct());
                orderProduct.setAmount(cartList.get(j).getAmount());
                orderProduct.setProductName(product.getName());
            }
            System.out.println(orderProduct);
            orderProductList.add(orderProduct);
        }
        System.out.println(orderProductList.size());
        System.out.println(orderProductList.get(0));
        theModel.addAttribute("orderProductList", orderProductList);
        return "dashboard/dash-my-order";
    }

    @GetMapping("/my_profile")
    public String myProfile(Model theModel){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            String user_phone = ((UserDetails)principal).getUsername();
            Customer customer = customerService.getCustomerByPhone(user_phone);
            miniCart(theModel, customer);
            theModel.addAttribute("user_full_name", customer.getNameCus());
            theModel.addAttribute("user_email", customer.getEmail());
            theModel.addAttribute("user_phone", customer.getPhone());
            theModel.addAttribute("user_dob", customer.getDob());
            if (customer.getSex() == 1){
                theModel.addAttribute("user_gender", "Male");
            }else {
                theModel.addAttribute("user_gender", "Female");
            }

        }
        else {
            String user_phone = principal.toString();
            Customer customer = customerService.getCustomerByPhone(user_phone);
            miniCart(theModel, customer);
            theModel.addAttribute("user_full_name", customer.getNameCus());
            theModel.addAttribute("user_email", customer.getEmail());
            theModel.addAttribute("user_phone", customer.getPhone());
            theModel.addAttribute("user_dob", customer.getDob());
            if (customer.getSex() == 1){
                theModel.addAttribute("user_gender", "Male");
            }else {
                theModel.addAttribute("user_gender", "Female");
            }
        }
        return "dashboard/dash-my-profile";
    }
    @GetMapping("/payment_option")
    public String paymentOption(Model theModel){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        miniCart(theModel, customer);
        theModel.addAttribute("user_full_name", customer.getNameCus());
        return "dashboard/dash-payment-option";
    }
    @GetMapping("/track_order")
    public String trackOrder(Model theModel){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        miniCart(theModel, customer);
        theModel.addAttribute("user_full_name", customer.getNameCus());
        return "dashboard/dash-track-order";
    }
    @GetMapping("/")
    public String dashboard(Model theModel){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        theModel.addAttribute("user_full_name", customer.getNameCus());
        theModel.addAttribute("user_email", customer.getEmail());
        theModel.addAttribute("user_address", customer.getAddress());
        theModel.addAttribute("user_phone", customer.getPhone());
        miniCart(theModel, customer);
        return "dashboard/dashboard";
    }
    // Support method
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
