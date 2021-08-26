package com.doan2.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Shipping_Company")
public class ShippingCompany {
    @Id
    @Column(name = "idSCompany")
    private int idSCompany;
    @Column(name = "idMethod")
    private int idMethod;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "name_SCompany")
    private String nameSCompany;
    @Column(name = "trading_Account")
    private int tradingAccount;
    public ShippingCompany() {
    }

    public ShippingCompany(int idSCompany, int idMethod, String phone, String address, String nameSCompany, int tradingAccount) {
        this.idSCompany = idSCompany;
        this.idMethod = idMethod;
        this.phone = phone;
        this.address = address;
        this.nameSCompany = nameSCompany;
        this.tradingAccount = tradingAccount;
    }


    public int getIdSCompany() {
        return idSCompany;
    }

    public void setIdSCompany(int idSCompany) {
        this.idSCompany = idSCompany;
    }

    public int getIdMethod() {
        return idMethod;
    }

    public void setIdMethod(int idMethod) {
        this.idMethod = idMethod;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNameSCompany() {
        return nameSCompany;
    }

    public void setNameSCompany(String nameSCompany) {
        this.nameSCompany = nameSCompany;
    }

    public int getTradingAccount() {
        return tradingAccount;
    }

    public void setTradingAccount(int tradingAccount) {
        this.tradingAccount = tradingAccount;
    }

    @Override
    public String toString() {
        return "ShippingCompany{" +
                "idSCompany='" + idSCompany + '\'' +
                ", idMethod='" + idMethod + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", nameSCompany='" + nameSCompany + '\'' +
                ", tradingAccount=" + tradingAccount +
                '}';
    }

}
