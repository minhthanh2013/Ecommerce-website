package com.doan2.spring.controller;

import com.doan2.spring.dao.userinfo.UserInfoDAO;
import com.doan2.spring.entity.Customer;
import com.doan2.spring.entity.supportentity.CustomerUser;
import com.doan2.spring.entity.UserInfo;
import com.doan2.spring.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    CustomerService customerService;
    @Autowired
    UserInfoDAO userInfoDAO;

    private Logger logger = Logger.getLogger(getClass().getName());

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @GetMapping("/")
    public String addUser(Model theModel){
        theModel.addAttribute("CustomerUser", new CustomerUser());
        return "/signin/signup";
    }
    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
          @ModelAttribute("CustomerUser") CustomerUser customerUser,
            BindingResult theBindingResult,
            Model theModel) {

        String userName = customerUser.getPhone();
        logger.info("Processing registration form for: " + userName);

        // form validation
//        if (theBindingResult.hasErrors()){
//            return "/signin/signup";
//        }

        // check the database if user already exists
        if (customerService.checkIfExists(userName)){
            theModel.addAttribute("CustomerUser", new CustomerUser());
            theModel.addAttribute("registrationError", "User name already exists.");

            logger.warning("User name already exists.");
            return "/signin/signup";
        }
        // create user account
        Customer customer = new Customer(customerService.getLatestId()+1,customerUser.getFullName(), customerUser.getPhone(), customerUser.getEmail(),"0", Date.valueOf(customerUser.getDateOfBirth()), "0",customerUser.getSex());
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(customerUser.getPhone());
        userInfo.setPassword(customerUser.getPassword());
        System.out.println(customer);
        customerService.saveCustomer(customer);
        userInfoDAO.addUserInfo(userInfo);

        logger.info("Successfully created user: " + userName);

        return "signin/registration-confirmation";
    }

}
