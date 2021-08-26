package com.doan2.spring.entity.supportentity;

import java.sql.Date;
import java.text.NumberFormat;
import java.util.Locale;

public class CartProduct {
    private int idCart;
    private int amount;
    private String name;
    private int total_money;
    private String type;
    private int idProduct;
    private int idSCompany;
    private int tranMethod;
    private int status;
    private String vnTotalMoney;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTranMethod() {
        return tranMethod;
    }

    public void setTranMethod(int tranMethod) {
        this.tranMethod = tranMethod;
    }

    public int getIdSCompany() {
        return idSCompany;
    }

    public void setIdSCompany(int idSCompany) {
        this.idSCompany = idSCompany;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public CartProduct() {
    }

    public CartProduct(int amount, String name, int total_money) {
        this.amount = amount;
        this.name = name;
        this.total_money = total_money;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal_money() {
        return total_money;
    }

    public void setTotal_money(int total_money) {
        this.total_money = total_money;
    }

    public String getVnTotalMoney() {
        return vnTotalMoney;
    }

    public void setVnTotalMoney(String vnTotalMoney) {
        this.vnTotalMoney = vnTotalMoney;
    }
}

