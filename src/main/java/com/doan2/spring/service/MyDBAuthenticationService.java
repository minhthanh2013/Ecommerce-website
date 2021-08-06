package com.doan2.spring.service;

import com.doan2.spring.dao.userinfo.UserInfoDAO;
import com.doan2.spring.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyDBAuthenticationService implements UserDetailsService {

    @Autowired
    private UserInfoDAO userInfoDAO;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoDAO.findUserInfo(s);
        List<String> roles= userInfoDAO.getUserRoles(s);
        String[] tempString = new String[roles.size()];
        for (int i = 0; i < roles.size(); i++) {
            tempString[i] = roles.get(i);
        }
        System.out.println("UserInfo= " + userInfo);

        if (userInfo == null) {
            throw new UsernameNotFoundException("User " + s + " was not found in the database");
        }

        // [USER,ADMIN,..]


        List<GrantedAuthority> grantList= new ArrayList<>();
        if(roles!= null)  {
            for(String role: roles)  {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
                grantList.add(authority);
            }
        }



        UserDetails userDetails = User.withUsername(userInfo.getUserName()).password(userInfo.getPassword()).authorities(grantList).build();
        System.out.println(userDetails.getAuthorities());


        return userDetails;
    }
}
