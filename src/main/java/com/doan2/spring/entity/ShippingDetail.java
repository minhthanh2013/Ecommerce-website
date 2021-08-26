package com.doan2.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
@Entity
@Table(name = "Shipping_detail")
public class ShippingDetail {
    @Id
    @Column (name = "idSCompany")
    private  int idSCompany;
    @Column (name = "idOrder")
    private int idOrder;
    @Column (name = "delivery_address")
    private String deliveryAddress;
    @Column (name = "start_date")
    private Date startDate;
    @Column (name = "delivery_time")
    private String deliveryTime;
    @Column (name = "status_Order")
    private int statusOrder;

    public ShippingDetail() {
    }

    public ShippingDetail(int idSCompany, int idOrder, String deliveryAddress, Date startDate, String deliveryTime, int statusOrder) {
        this.idSCompany = idSCompany;
        this.idOrder = idOrder;
        this.deliveryAddress = deliveryAddress;
        this.startDate = startDate;
        this.deliveryTime = deliveryTime;
        this.statusOrder = statusOrder;
    }

    public int getIdSCompany() {
        return idSCompany;
    }

    public void setIdSCompany(int idSCompany) {
        this.idSCompany = idSCompany;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(int statusOrder) {
        this.statusOrder = statusOrder;
    }

    @Override
    public String toString() {
        return "ShippingDetail{" +
                "idSCompany='" + idSCompany + '\'' +
                ", idOrder='" + idOrder + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", startDate=" + startDate +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", statusOrder=" + statusOrder +
                '}';
    }
}
