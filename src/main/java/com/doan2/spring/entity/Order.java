package com.doan2.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
@Entity
@Table(name="Order_Table")
public class Order {
    @Column(name="idCus")
    private String idCus;
    @Id
    @Column(name="idOrder")
    private String idOrder;
    @Column(name="idSup")
    private String idSup;
    @Column(name="date")
    private Date date;
    @Column(name="status")
    private int status;
    @Column(name="tran_method")
    private String tranMethod;
    @Column(name="delivery_address")
    private String deliveryAddress;
    @Column(name="total_money")
    private int totalMoney;

    public Order() {
    }

    public Order(String idCus, String idOrder, String idSup, Date date, int status, String tranMethod, String deliveryAddress, int totalMoney) {
        this.idCus = idCus;
        this.idOrder = idOrder;
        this.idSup = idSup;
        this.date = date;
        this.status = status;
        this.tranMethod = tranMethod;
        this.deliveryAddress = deliveryAddress;
        this.totalMoney = totalMoney;
    }

    public String getIdCus() {
        return idCus;
    }

    public void setIdCus(String idCus) {
        this.idCus = idCus;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdSup() {
        return idSup;
    }

    public void setIdSup(String idSup) {
        this.idSup = idSup;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTranMethod() {
        return tranMethod;
    }

    public void setTranMethod(String tranMethod) {
        this.tranMethod = tranMethod;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idCus='" + idCus + '\'' +
                ", idOrder='" + idOrder + '\'' +
                ", idSup='" + idSup + '\'' +
                ", date=" + date +
                ", status=" + status +
                ", tranMethod='" + tranMethod + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", totalMoney=" + totalMoney +
                '}';
    }
}