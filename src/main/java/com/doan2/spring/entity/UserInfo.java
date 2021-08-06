package com.doan2.spring.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


public class UserInfo {
    private String userName;
    private String password;


    public UserInfo() {


    }

    public UserInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }




    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
