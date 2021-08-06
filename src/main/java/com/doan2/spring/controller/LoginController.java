package com.doan2.spring.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    //@GetMapping("/showMyLoginPage")
    @GetMapping("/login")
    public String showMyLoginPage(HttpServletRequest request, Model model){
        String referrer = request.getHeader("Referer");
        request.getSession().setAttribute("url_prior_login", referrer);
//        return "plain-login";
//        return "fancy-login";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {

            /* The user is logged in :) */
            return "forward:/";
        }
        return "signin/signin";
    }
    // add request mapping for access denied
    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "exception-handler/404";
    }

//    @GetMapping("/login")
//    public String login(){
//        return "signin/signin";
//    }
}
