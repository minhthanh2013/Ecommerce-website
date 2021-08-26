package com.doan2.spring.controller;

import com.doan2.spring.entity.*;
import com.doan2.spring.entity.supportentity.CartProduct;
import com.doan2.spring.service.cart.CartService;
import com.doan2.spring.service.cungcap.CungCapService;
import com.doan2.spring.service.customer.CustomerService;
import com.doan2.spring.service.order.OrderService;
import com.doan2.spring.service.product.ProductService;
import com.doan2.spring.service.product.ProductTypeService;
import com.doan2.spring.service.shippingcompany.ShippingCompanyService;
import com.doan2.spring.service.shippingcompany.ShippingDetailService;
import com.doan2.spring.service.shippingfee.ShippingFeeService;
import com.doan2.spring.service.supplier.SupplierLogService;
import com.doan2.spring.service.supplier.SupplierService;
import com.doan2.spring.service.tradingpartner.TradingPartnerLogService;
import com.doan2.spring.service.tradingpartner.TradingPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.NumberFormat;
import java.util.*;

@Controller
@RequestMapping("/checkout")
public class CheckOutController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private ShippingCompanyService shippingCompanyService;
    @Autowired
    private ShippingDetailService shippingDetailService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private CungCapService cungCapService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ShippingFeeService shippingFeeService;
    @Autowired
    private TradingPartnerLogService tradingPartnerLogService;
    @Autowired
    private TradingPartnerService tradingPartnerService;
    @Autowired
    private SupplierLogService supplierLogService;
    @GetMapping("/")
    public String checkOut(Model theModel){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);

        miniCart(theModel, customer);
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
            cartProduct.setIdProduct(product.getIdProduct());
            cartProductList.add(cartProduct);
            sum += cartProduct.getTotal_money();
        }

        if (cartProductList.size()==0) return "exception-handler/404";
        System.out.println(cartProductList.size());

        List<ShippingCompany> shippingCompanyList = shippingCompanyService.getAll();
        System.out.println(shippingCompanyList.size());
        theModel.addAttribute("customer_address", customer.getAddress());
//        theModel.addAttribute("customer_phone" , customer.getPhone());
        String temp = "";
        String split[] = customer.getBankAccount().split("-");
        for (int i = 0; i < split[1].length(); i++) {
            if (i == 0 || i == 1 || i == 2) temp+= split[1].charAt(i);
            else if(i== split[1].length()-1) {
                temp+= split[1].charAt(i);
            }
            else{
                temp+="*";
            }
        }
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        theModel.addAttribute("date_order", date);
        String resBank = "Bank: "+split[0] +" - "+temp;
        theModel.addAttribute("customer_bankAccount", resBank);
        theModel.addAttribute("total_money", sum);

        theModel.addAttribute("cartProductList", cartProductList);
        theModel.addAttribute("shippingCompanyList", shippingCompanyList);
        theModel.addAttribute("cartProductModel", new CartProduct());
        Order tempOrder = new Order();
        tempOrder.setStatus(0);
        tempOrder.setTotalMoney(sum);
        theModel.addAttribute("orderModel" , tempOrder);

        return "checkout/checkout";
    }
    @PostMapping("/")
    public String checkOutPost(@ModelAttribute("orderModel") Order order,
                               @ModelAttribute("cartProductModel") CartProduct cartProduct,
                               Model theModel)
    {

//                               @RequestParam String tranMethod){
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        System.out.println("120 "+cartProduct.getIdSCompany());
        System.out.println("121 "+order.getTranMethod());
        System.out.println(orderService.getLatestId().get(0));
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_phone = ((UserDetails)principal).getUsername();
        Customer customer = customerService.getCustomerByPhone(user_phone);
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        order.setDate(date);
        //order.setTranMethod(tranMethod);

        order.setDeliveryAddress(customer.getAddress());
        order.setIdCus(customer.getIdCus());

        order.setIdOrder(orderService.getLatestId().get(0)+1);
        order.setDeliveryAddress(customer.getAddress());
        System.out.println(order);
        orderService.saveOrder(order);
        List<Cart> cartListNotCheckOut = cartService.getListCartNotCheckOut(customer.getIdCus());
        for (int i = 0; i < cartListNotCheckOut.size(); i++) {
            SupplierLog supplierLog = new SupplierLog();
            supplierLog.setDate(order.getDate());
            supplierLog.setIdOrder(order.getIdOrder());
            supplierLog.setStatus(order.getStatus());
            int tempDouble = (int) (0.98 * cartListNotCheckOut.get(i).getTotal_money());
            supplierLog.setTotalMoney(tempDouble);
            CungCap cungCap = cungCapService.getByIdProduct(cartListNotCheckOut.get(i).getIdProduct());
            supplierLog.setIdSup(cungCap.getIdSup());
            supplierLog.setIdLog(supplierLogService.getLatestIdLog().get(0)+1);
            supplierLogService.save(supplierLog);
        }



        ShippingDetail shippingDetail = new ShippingDetail();
        shippingDetail.setIdOrder(order.getIdOrder());
        shippingDetail.setIdSCompany(cartProduct.getIdSCompany());
        shippingDetail.setDeliveryAddress(order.getDeliveryAddress());
        shippingDetail.setStartDate(order.getDate());
        shippingDetail.setStatusOrder(order.getStatus());

        String[]split1 = order.getDeliveryAddress().split(",");
        ShippingFee shippingFee = new ShippingFee();
        if (split1[2].trim().toLowerCase(Locale.ROOT).equals("ho chi minh")|| split1[2].trim().toLowerCase(Locale.ROOT).equals("ha noi") || split1[2].trim().toLowerCase(Locale.ROOT).equals("da nang")){
            shippingDetail.setDeliveryTime("1-3 days");
            shippingFee.setShippingFee(30000);
        }else{
            shippingDetail.setDeliveryTime("3-7 days");
            shippingFee.setShippingFee(50000);
        }


        shippingFee.setDeliveryTime(shippingDetail.getDeliveryTime());
        shippingFee.setIdOrder(order.getIdOrder());
        shippingFee.setIdSCompany(cartProduct.getIdSCompany());
        System.out.println(shippingDetail);
        System.out.println(shippingFee);
        shippingDetailService.addShippingDetail(shippingDetail);
        shippingFeeService.saveShippingFee(shippingFee);

        String cus_bank = customer.getBankAccount();
        String split[] = cus_bank.split("-");
        if (order.getTranMethod().equals("3")){
            int tradingPartnerId = tradingPartnerService.getIdPartnerByName(split[0].trim()).get(0);
            TradingPartnerLog tradingPartnerLog = new TradingPartnerLog();
            tradingPartnerLog.setIdPartner(tradingPartnerId);
            tradingPartnerLog.setIdOrder(order.getIdOrder());
            tradingPartnerLog.setDate(order.getDate());
            tradingPartnerLog.setStatus(order.getStatus());
            tradingPartnerLog.setTotalMoney(order.getTotalMoney());
            System.out.println("189 "+tradingPartnerLog.getTotalMoney());
            tradingPartnerLog.setIdLog(tradingPartnerLogService.getLatestIdLog().get(0)+1);
            tradingPartnerLogService.save(tradingPartnerLog);
        }
        List<Cart> cartList = cartService.getListCartNotCheckOut(customer.getIdCus());
        for (int i = 0; i < cartList.size(); i++) {
            cartList.get(i).setIdOrder(order.getIdOrder());
            cartService.saveCart(cartList.get(i));
        }

        theModel.addAttribute("cus_name", customer.getNameCus());
        theModel.addAttribute("cus_address", customer.getAddress());
        theModel.addAttribute("cus_phone", customer.getPhone());
        theModel.addAttribute("order_id", order.getIdOrder());
        String[] tempSplit1 = shippingDetail.getDeliveryTime().split("-");
        String[] tempSplit2 = order.getDate().toString().split("-");
        String[] tempSplit3 = tempSplit1[1].split(" ");
        int startDay = Integer.parseInt(tempSplit2[2]) + Integer.parseInt(tempSplit1[0]);
        int endDay = Integer.parseInt(tempSplit2[2]) + Integer.parseInt(tempSplit3[0]);
        String startDate = startDay+"/"+tempSplit2[1]+"/"+tempSplit2[0];
        String endDate = endDay+"/"+tempSplit2[1]+"/"+tempSplit2[0];
        theModel.addAttribute("start_date", startDate);
        theModel.addAttribute("end_date", endDate);
        String tranMethodFin;
        if (order.getTranMethod().equals("1")){
            tranMethodFin = "Cash on delivery";
        }else if (order.getTranMethod().equals("2")){
            tranMethodFin = "Momo";
        } else {
            tranMethodFin = "Bank";
        }
        theModel.addAttribute("payment_option", tranMethodFin);
        System.out.println(order.getTotalMoney());
        System.out.println(shippingFee.getShippingFee());
        Order newOrder = orderService.getOrder(order.getIdOrder());
        int totalFinal = newOrder.getTotalMoney() + shippingFee.getShippingFee();
        String temp1 = currencyVN.format(totalFinal);
        theModel.addAttribute("final_total", temp1);
        return "checkout/checkout-success";
    }
    @GetMapping("/success")
    public String checkOutSuccess(Model theModel){
        return "checkout/checkout-success";
    }
    public void miniCart(Model theModel, Customer customer){
        List<Cart> cartList = cartService.getListCartNotCheckOut(customer.getIdCus());
        int sum = 0;
        List<CartProduct> cartProductList = new ArrayList<>();
        for (int i = 0; i < cartList.size(); i++) {
            Product product = productService.getProduct(cartList.get(i).getIdProduct());
            CartProduct cartProduct = new CartProduct(cartList.get(i).getAmount(),product.getName(), cartList.get(i).getTotal_money());
            sum += cartList.get(i).getTotal_money();
            cartProduct.setIdProduct(product.getIdProduct());
            Optional<ProductType> productType = productTypeService.getById(product.getIdType());
            cartProduct.setType(productType.get().getNameType());
            cartProductList.add(cartProduct);
        }
        theModel.addAttribute("total_amount", cartList.size());
        theModel.addAttribute("cart_product_total", sum);
        theModel.addAttribute("cart_product_list", cartProductList);

        List<Order> orderList = orderService.getOrderByCustomerId(customer.getIdCus());
        theModel.addAttribute("order_list", orderList);
    }
}
