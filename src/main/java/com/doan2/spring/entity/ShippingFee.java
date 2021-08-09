package com.doan2.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Shipping_Fee")
public class ShippingFee {
    @Id
    @Column(name="idOrder")
    private int idOrder;

    @Column(name="idSCompany")
    private int idSCompany;

    @Column(name="shipping_fee")
    private int shippingFee;
    @Column(name="delivery_time")
    private String deliveryTime;

    public ShippingFee() {
    }

    public ShippingFee(int idOrder, int idSCompany, int shippingFee, String deliveryTime) {
        this.idOrder = idOrder;
        this.idSCompany = idSCompany;
        this.shippingFee = shippingFee;
        this.deliveryTime = deliveryTime;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdSCompany() {
        return idSCompany;
    }

    public void setIdSCompany(int idSCompany) {
        this.idSCompany = idSCompany;
    }

    public int getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(int shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Override
    public String toString() {
        return "ShippingFee{" +
                "idOrder='" + idOrder + '\'' +
                ", idSCompany='" + idSCompany + '\'' +
                ", shippingFee=" + shippingFee +
                ", deliveryTime='" + deliveryTime + '\'' +
                '}';
    }
}
