package com.doan2.spring.entity.supportentity;

import java.sql.Date;
import java.util.List;

public class CustomerRole {
    private String phone;
    private String fullName;
    private String email;
    private List<String> roles;
    private Date lastLogin;

    public CustomerRole() {
    }

    public CustomerRole(String phone, String fullName, String email, List<String> roles, Date lastLogin) {
        this.phone = phone;
        this.fullName = fullName;
        this.email = email;
        this.roles = roles;
        this.lastLogin = lastLogin;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "CustomerRole{" +
                "phone='" + phone + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
