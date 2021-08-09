package com.doan2.spring.entity.supportentity;

public class CartProduct {
    private int amount;
    private String name;
    private int total_money;

    public CartProduct() {
    }

    public CartProduct(int amount, String name, int total_money) {
        this.amount = amount;
        this.name = name;
        this.total_money = total_money;
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
}

