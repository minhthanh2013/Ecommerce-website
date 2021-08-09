package com.doan2.spring.entity.supportentity;

import java.sql.Date;

public class OrderProduct {
    private int idOrder;
    private Date date;
    private String productName;
    private int amount;
    private int totalMoney;
    private String status;

    public OrderProduct() {
    }

    public OrderProduct(int idOrder, Date date, String productName, int amount, int totalMoney, String status) {
        this.idOrder = idOrder;
        this.date = date;
        this.productName = productName;
        this.amount = amount;
        this.totalMoney = totalMoney;
        this.status = status;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "idOrder=" + idOrder +
                ", date=" + date +
                ", productName='" + productName + '\'' +
                ", amount=" + amount +
                ", totalMoney=" + totalMoney +
                ", status='" + status + '\'' +
                '}';
    }
}
