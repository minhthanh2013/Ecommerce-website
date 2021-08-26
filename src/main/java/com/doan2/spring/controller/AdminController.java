package com.doan2.spring.controller;


import com.doan2.spring.entity.*;
import com.doan2.spring.entity.supportentity.CustomerRole;
import com.doan2.spring.entity.supportentity.OrderTradingShipping;

import com.doan2.spring.entity.supportentity.SupplierInfo;
import com.doan2.spring.repository.OrderRepository;
import com.doan2.spring.service.cungcap.CungCapService;
import com.doan2.spring.service.customer.CustomerService;
import com.doan2.spring.service.order.OrderService;
import com.doan2.spring.service.revenue.RevenueLogService;
import com.doan2.spring.service.shippingcompany.ShippingCompanyService;
import com.doan2.spring.service.shippingcompany.ShippingDetailService;
import com.doan2.spring.service.supplier.SupplierLogService;
import com.doan2.spring.service.supplier.SupplierService;
import com.doan2.spring.service.tradingpartner.TradingPartnerLogService;
import com.doan2.spring.service.tradingpartner.TradingPartnerService;
import com.doan2.spring.service.userrole.UserRoleService;
import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    RevenueLogService revenueLogService;
    @Autowired
    OrderService orderService;
    @Autowired
    ShippingCompanyService shippingCompanyService;
    @Autowired
    ShippingDetailService shippingDetailService;
    @Autowired
    TradingPartnerService tradingPartnerService;
    @Autowired
    TradingPartnerLogService tradingPartnerLogService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    UserRoleService userRoleRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    SupplierService supplierService;
    @Autowired
    SupplierLogService supplierLogService;
    @Autowired
    CungCapService customerRoleList;
    private final String URL_SHIPPING_COMPANY = "http://localhost:8080/doan2_new_war/api/shipping_company/shipping_companies";
    private final String URL_PARTNER_COMPANY = "http://localhost:8080/doan2_new_war/api/partner/partners";
    private final String URL_CUSTOMER_COMPANY = "http://localhost:8080/doan2_new_war/api/customer/customers";
    private final String URL_ORDER = "http://localhost:8080/doan2_new_war/api/order/suppliers";
    private final String URL_SUPPLIER = "http://localhost:8080/doan2_new_war/api/supplier/suppliers";

    @RequestMapping("/users")
    public String adminUser(Model theModel,
                            @RequestParam(required = false, defaultValue = "0") String page,
                            @RequestParam(required = false) String name
    ) throws IOException, InterruptedException {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails) principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);

        theModel.addAttribute("user_full_name", customer.getNameCus());
        List<Integer> integers = new ArrayList<>();
        int totalPage = customerService.getAll().size() / 5;
        for (int i = 0; i <= totalPage; i++) {
            integers.add(i);
        }

        theModel.addAttribute("pageValList", integers);
        HttpResponse<String> response1;
        ObjectMapper mapper1 = new ObjectMapper();
        if (name != null) {
            response1 = getList(URL_CUSTOMER_COMPANY, name, null, 1);

            JSONObject jsonObject = new JSONObject(response1.body());
            List<Customer> tradingPartnerList = mapper1.readValue(jsonObject.get("content").toString(), new TypeReference<List<Customer>>() {
            });
            System.out.println(tradingPartnerList);
            List<CustomerRole> customerRoleList = new ArrayList<>();
            for (int i = 0; i < tradingPartnerList.size(); i++) {
                CustomerRole customerRole = new CustomerRole();

                customerRole.setFullName(tradingPartnerList.get(i).getNameCus());
                customerRole.setEmail(tradingPartnerList.get(i).getEmail());
                customerRole.setPhone(tradingPartnerList.get(i).getPhone());
                customerRole.setLastLogin(Date.valueOf("2021-7-7"));
                customerRole.setRoles(userRoleRepository.getUserRoleByUsername(tradingPartnerList.get(i).getPhone()));

                customerRoleList.add(customerRole);
            }

            theModel.addAttribute("customerList", customerRoleList);

        } else {
            response1 = getList(URL_CUSTOMER_COMPANY, page, null, 0);

            JSONObject jsonObject = new JSONObject(response1.body());

            List<Customer> tradingPartnerList = mapper1.readValue(jsonObject.get("content").toString(), new TypeReference<List<Customer>>() {
            });
            System.out.println(tradingPartnerList);
            List<CustomerRole> customerRoleList = new ArrayList<>();
            for (int i = 0; i < tradingPartnerList.size(); i++) {
                CustomerRole customerRole = new CustomerRole();

                customerRole.setFullName(tradingPartnerList.get(i).getNameCus());
                customerRole.setEmail(tradingPartnerList.get(i).getEmail());
                customerRole.setPhone(tradingPartnerList.get(i).getPhone());
                customerRole.setLastLogin(Date.valueOf("2021-7-7"));
                customerRole.setRoles(userRoleRepository.getUserRoleByUsername(tradingPartnerList.get(i).getPhone()));

                customerRoleList.add(customerRole);
            }

            theModel.addAttribute("customerList", customerRoleList);

        }
        return "admin/admin-users";

    }

    @PostMapping("/users")
    public String processChangeRole(@RequestParam String phone, @RequestParam String role, Model theModel) {
        System.out.println(phone);
        System.out.println(role);
        List<UserRole> userRoleList = userRoleRepository.getAllByUsername(phone);
        if (userRoleList.size() == 0) {
            theModel.addAttribute("check_update_error", "User not existed.");
            return "redirect:admin-users";
        }
        for (int i = 0; i < userRoleList.size(); i++) {
            UserRole userRole = userRoleList.get(i);

            userRole.setRole(role);
            // userRoleList.set(i, userRole);
            userRoleService.saveUserRole(userRole);
        }

        // userRoleRepository.saveAll(userRoleList);
        theModel.addAttribute("check_update_success", "Success change user's role!");
        return "redirect:admin-users";
    }

    @RequestMapping("/manage_order")
    public String adminTrackOrder(@RequestParam Integer idSup, Model theModel,
                                  @RequestParam String page) throws IOException, InterruptedException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails) principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        theModel.addAttribute("user_full_name", customer.getNameCus());
        Optional<Supplier> theSupplier = supplierService.getSupplier(idSup);
        theModel.addAttribute("supplier_name", theSupplier.get().getNameSup());
        theModel.addAttribute("id_sup", idSup);
        HttpResponse<String> response1;
        ObjectMapper mapper1 = new ObjectMapper();
        response1 = getList(URL_ORDER, String.valueOf(idSup), page, 3);

        JSONObject jsonObject = new JSONObject(response1.body());
        List<Order> orderList = mapper1.readValue(jsonObject.get("content").toString(), new TypeReference<List<Order>>() {
        });
        List<Integer> integers = new ArrayList<>();
        int totalPage = orderList.size() / 5;
        for (int i = 0; i <= totalPage; i++) {
            integers.add(i);
        }
        theModel.addAttribute("pageValList", integers);
        double sum = 0;
        for (int i = 0; i < orderList.size(); i++) {
            sum += orderList.get(i).getTotalMoney();
        }
        BigDecimal tempBig = new BigDecimal(Double.toString(sum));
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String temp = currencyVN.format(tempBig);
        theModel.addAttribute("order_total_money", temp);

        theModel.addAttribute("orderList", orderList);

        return "admin/admin-manage-order";
    }

    @RequestMapping("/suppliers")
    public String adminSupplier(@RequestParam(required = false, defaultValue = "0") String page,
                                @RequestParam(required = false) String name, Model theModel) throws IOException, InterruptedException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails) principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);

        theModel.addAttribute("user_full_name", customer.getNameCus());
        List<Integer> integers = new ArrayList<>();
        int totalPage = supplierService.getAll().size() / 5;
        for (int i = 0; i <= totalPage; i++) {
            integers.add(i);
        }
        theModel.addAttribute("pageValList", integers);
        HttpResponse<String> response1;
        ObjectMapper mapper1 = new ObjectMapper();
        if (name != null) {
            response1 = getList(URL_SUPPLIER, name, null, 1);

            JSONObject jsonObject = new JSONObject(response1.body());
            List<Supplier> supplierList = mapper1.readValue(jsonObject.get("content").toString(), new TypeReference<List<Supplier>>() {
            });
            List<SupplierInfo> supplierInfoList = new ArrayList<>();
            for (int i = 0; i < supplierList.size(); i++) {
                int idSup = supplierList.get(i).getIdSup();

                SupplierInfo supplierInfo = new SupplierInfo();
                supplierInfo.setIdSup(idSup);
                supplierInfo.setAddress(supplierList.get(i).getAddress());
                supplierInfo.setNameSup(supplierList.get(i).getNameSup());

                supplierInfo.setMonthlyRevenue(supplierLogService.getMonthRevenue(8));
                String temp = currencyVN.format(supplierLogService.getMonthRevenue(8));
                String temp1 = currencyVN.format(supplierLogService.getTotalRevenue());
                supplierInfo.setTotalRevenue(supplierLogService.getTotalRevenue());
                supplierInfo.setVnTotalMoneyMonth(temp);
                supplierInfo.setVnTotalMoneyTotal(temp1);
                supplierInfo.setRate(5);

                supplierInfoList.add(supplierInfo);
            }

            theModel.addAttribute("supplier_list", supplierInfoList);

        } else {
            response1 = getList(URL_SUPPLIER, page, null, 0);

            JSONObject jsonObject = new JSONObject(response1.body());
            List<Supplier> supplierList = mapper1.readValue(jsonObject.get("content").toString(), new TypeReference<List<Supplier>>() {
            });
            List<SupplierInfo> supplierInfoList = new ArrayList<>();
            for (int i = 0; i < supplierList.size(); i++) {
                int idSup = supplierList.get(i).getIdSup();

                SupplierInfo supplierInfo = new SupplierInfo();
                supplierInfo.setIdSup(idSup);
                supplierInfo.setAddress(supplierList.get(i).getAddress());
                supplierInfo.setNameSup(supplierList.get(i).getNameSup());

                supplierInfo.setMonthlyRevenue(supplierLogService.getMonthRevenue(8));
                supplierInfo.setTotalRevenue(supplierLogService.getTotalRevenue());
                supplierInfo.setRate(5);
                supplierInfoList.add(supplierInfo);
            }

            theModel.addAttribute("supplier_list", supplierInfoList);

        }
        //return "admin/admin-users";
        return "admin/admin-suppliers";
    }

    @RequestMapping("/shipping_company")
    public String adminShippingCompany(@RequestParam(required = false, defaultValue = "0") String page,
                                       @RequestParam(required = false) String name,
                                       @RequestParam(required = false) Integer idSCompany,
                                       Model theModel) throws IOException, InterruptedException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails) principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);

        theModel.addAttribute("user_full_name", customer.getNameCus());

        List<Integer> integers = new ArrayList<>();
        int totalPage = shippingCompanyService.getAll().size() / 5;
        for (int i = 0; i <= totalPage; i++) {
            integers.add(i);
        }
        theModel.addAttribute("pageValList", integers);
        HttpResponse<String> response1;
        ObjectMapper mapper1 = new ObjectMapper();
        if (name != null) {
            response1 = getList(URL_SHIPPING_COMPANY, name, null, 1);

            JSONObject jsonObject = new JSONObject(response1.body());
            List<ShippingCompany> shipping_company_list = mapper1.readValue(jsonObject.get("content").toString(), new TypeReference<List<ShippingCompany>>() {
            });


            if (idSCompany != null) {
                List<Order> orderList = new ArrayList<>();

                List<ShippingDetail> shippingDetailList = shippingDetailService.getListShippingDetailById(idSCompany);
                for (int i = 0; i < shippingDetailList.size(); i++) {
                    Order order = orderService.getOrder(shippingDetailList.get(i).getIdOrder());
                    orderList.add(order);
                }
                Set<Order> finalSet = new HashSet<>(orderList);
                orderList.clear();
                orderList.addAll(finalSet);
                theModel.addAttribute("order_list", orderList);

            }
            theModel.addAttribute("total_shipping", shipping_company_list.size());
            theModel.addAttribute("shipping_company_list", shipping_company_list);

        } else {
            response1 = getList(URL_SHIPPING_COMPANY, page, null, 0);

            JSONObject jsonObject = new JSONObject(response1.body());
            List<ShippingCompany> shipping_company_list = mapper1.readValue(jsonObject.get("content").toString(), new TypeReference<List<ShippingCompany>>() {
            });


            if (idSCompany != null) {
                List<Order> orderList = new ArrayList<>();

                List<ShippingDetail> shippingDetailList = shippingDetailService.getListShippingDetailById(idSCompany);
                for (int i = 0; i < shippingDetailList.size(); i++) {
                    Order order = orderService.getOrder(shippingDetailList.get(i).getIdOrder());
                    orderList.add(order);
                }

                Set<Order> finalSet = new HashSet<>(orderList);
                orderList.clear();
                orderList.addAll(finalSet);
                theModel.addAttribute("order_list", orderList);
                theModel.addAttribute("total_shipping", shipping_company_list.size());
            }
            theModel.addAttribute("shipping_company_list", shipping_company_list);

        }

        return "admin/admin-shipping-company";
    }

    @RequestMapping("/partners")
    public String adminPartner(Model theModel,
                               @RequestParam(required = false, defaultValue = "0") String page,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) Integer id) throws IOException, InterruptedException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails) principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        if (id != null) {
            TradingPartner tradingPartner = tradingPartnerService.getTradingPartnerById(id);
            theModel.addAttribute("trading_partner_fr_id", tradingPartner);
            List<TradingPartnerLog> tradingPartnerLogList = tradingPartnerLogService.getAllByIdSup(id);
            int sum = 0;
            for (TradingPartnerLog tempLog :
                    tradingPartnerLogList) {
                sum += tempLog.getTotalMoney();
            }
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String temp = currencyVN.format(sum);
            theModel.addAttribute("total_amount_traded", temp);

        }
        theModel.addAttribute("user_full_name", customer.getNameCus());
        List<Integer> integers = new ArrayList<>();
        int totalPage = tradingPartnerService.getAll().size() / 5;
        for (int i = 0; i <= totalPage; i++) {
            integers.add(i);
        }

        theModel.addAttribute("pageValList", integers);

        HttpResponse<String> response1;
        ObjectMapper mapper1 = new ObjectMapper();
        if (name == null) {
            response1 = getList(URL_PARTNER_COMPANY, page, null, 0);
            JSONObject jsonObject = new JSONObject(response1.body());
            System.out.println(jsonObject.get("content"));
            List<TradingPartner> tradingPartnerList = mapper1.readValue(jsonObject.get("content").toString(), new TypeReference<List<TradingPartner>>() {
            });
            theModel.addAttribute("partnerList", tradingPartnerList);
            theModel.addAttribute("total_partner", tradingPartnerList.size());
        } else {
            response1 = getList(URL_PARTNER_COMPANY, name, null, 1);
            JSONObject jsonObject = new JSONObject(response1.body());
            System.out.println(jsonObject.get("content"));
            List<TradingPartner> tradingPartnerList = mapper1.readValue(jsonObject.get("content").toString(), new TypeReference<List<TradingPartner>>() {
            });
            theModel.addAttribute("partnerList", tradingPartnerList);
            theModel.addAttribute("total_partner", tradingPartnerList.size());
        }
        return "admin/admin-partners";
    }

    @GetMapping("/processId")
    public String getProcessId(@RequestParam Integer id, Model theModel) {
        System.out.println("115 " + id);
        TradingPartner tradingPartner = tradingPartnerService.getTradingPartnerById(id);
        theModel.addAttribute("trading_partner_fr_id", tradingPartner);
        return "redirect/redirectAdminPartner";
    }

    @PostMapping("/processId")
    public String processId(@RequestParam Integer id, Model theModel) {
        System.out.println("113 " + id);
        TradingPartner tradingPartner = tradingPartnerService.getTradingPartnerById(id);
        theModel.addAttribute("trading_partner_fr_id", tradingPartner);
        return "redirect/redirectAdminPartner";
    }

    @RequestMapping("/")
    public String adminDashboard(Model theModel) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails) principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        theModel.addAttribute("user_full_name", customer.getNameCus());
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        List<RevenueLog> revenueLogListThisMonth = revenueLogService.getRevenueLogByMonth(currentMonth);
        System.out.println(revenueLogListThisMonth.size());
        int sum = 0;
        for (int i = 0; i < revenueLogListThisMonth.size(); i++) {
            sum += revenueLogListThisMonth.get(i).getTotal_money();
        }
        int sum1 = 0;
        List<RevenueLog> revenueLogList = revenueLogService.getRevenues();
        for (int i = 0; i < revenueLogList.size(); i++) {
            sum1 += revenueLogList.get(i).getTotal_money();
        }
        List<Order> orderList = orderService.recentOrderThisWeek();
        List<OrderTradingShipping> orderTradingShippingList = new ArrayList<>();
        for (int i = 0; i < orderList.size(); i++) {
            OrderTradingShipping orderTradingShipping = new OrderTradingShipping();
            int idOrder = orderList.get(i).getIdOrder();
            String tranMethod = orderList.get(i).getTranMethod();
            if (tranMethod.equals("1")||tranMethod.equals("2")){
                continue;
            }
            System.out.println(idOrder);
            TradingPartnerLog tradingPartnerLog = tradingPartnerLogService.getTradingPartnerLogByIdOrder(idOrder);
            int idPartner = tradingPartnerLog.getIdPartner();
            TradingPartner tradingPartner = tradingPartnerService.getTradingPartnerById(idPartner);

            ShippingDetail shippingDetail = shippingDetailService.getShippingDetailByIdOrder(idOrder);

            ShippingCompany shippingCompany = shippingCompanyService.getShippingCompanyById(shippingDetail.getIdSCompany());


            orderTradingShipping.setIdOrder(idOrder);
            orderTradingShipping.setDate(orderList.get(i).getDate());
            orderTradingShipping.setNamePartner(tradingPartner.getNamePartner());
            orderTradingShipping.setTotalMoney(orderList.get(i).getTotalMoney());
            orderTradingShipping.setNameSCompany(shippingCompany.getNameSCompany());
            String temp = currencyVN.format(orderList.get(i).getTotalMoney());
            orderTradingShipping.setVnTotalMoney(temp);
            orderTradingShippingList.add(orderTradingShipping);

        }
        String temp = currencyVN.format(sum);
        String temp1 = currencyVN.format(sum1);
        theModel.addAttribute("revenue_this_month", temp);
        theModel.addAttribute("revenue_total", temp1);
        theModel.addAttribute("orderTradingShippingList", orderTradingShippingList);

        return "admin/admin-dashboard";
    }

    //    @RequestMapping("/page={page}")
//    public String adminDashboardWithPage(@PathVariable String page, Model theModel) throws IOException, InterruptedException {
//
//        HttpResponse<String> response1 = getList(URL_SHIPPING_COMPANY, page);
//        ObjectMapper mapper1 = new ObjectMapper();
//        List<ShippingCompany> shippingCompanyList = mapper1.readValue(response1.body(), new TypeReference< List<ShippingCompany>>() {
//        });
//        theModel.addAttribute("shippingList", shippingCompanyList);
//        return "admin/admin-dashboard";
//    }
    public HttpResponse<String> getList(String url, String page, String tempStr, int isPage) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        //String newString = url+
        System.out.println("455 " + page);
        System.out.println("455 " + tempStr);
        String temp = null;
        if (isPage == 0 && tempStr == null) {
            temp = url + "?page=" + URLEncoder.encode(page);
        } else if (isPage == 1 && tempStr == null) {
            temp = url + "?name=" + URLEncoder.encode(page);
        } else if (isPage == 3 && tempStr != null) {
            temp = url + "?idSup=" + URLEncoder.encode(page);
        }
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
