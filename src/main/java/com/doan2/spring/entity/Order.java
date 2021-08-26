package com.doan2.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

@Entity
@Table(name="Order_Table")
public class Order {
    @Column(name="idCus")
    private int idCus;
    @Id
    @Column(name="idOrder")
    private Integer idOrder;
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

    public Order(int idCus, int idOrder, Date date, int status, String tranMethod, String deliveryAddress, int totalMoney) {
        this.idCus = idCus;
        this.idOrder = idOrder;
        this.date = date;
        this.status = status;
        this.tranMethod = tranMethod;
        this.deliveryAddress = deliveryAddress;
        this.totalMoney = totalMoney;
    }

    public int getIdCus() {
        return idCus;
    }

    public void setIdCus(int idCus) {
        this.idCus = idCus;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return idCus == order.idCus && status == order.status && totalMoney == order.totalMoney && Objects.equals(idOrder, order.idOrder) && Objects.equals(date, order.date) && Objects.equals(tranMethod, order.tranMethod) && Objects.equals(deliveryAddress, order.deliveryAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCus, idOrder, date, status, tranMethod, deliveryAddress, totalMoney);
    }

    @Override
    public String toString() {
        return "Order{" +
                "idCus=" + idCus +
                ", idOrder=" + idOrder +
                ", date=" + date +
                ", status=" + status +
                ", tranMethod='" + tranMethod + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", totalMoney=" + totalMoney +
                '}';
    }
}