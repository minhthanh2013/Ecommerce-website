package com.doan2.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @Column(name = "idCart")
    private int id;
    @Column(name = "idProduct")
    private int idProduct;
    @Column(name = "idOrder")
    private Integer  idOrder;
    @Column(name = "price")
    private int price;
    @Column(name = "amount")
    private int amount;
    @Column(name = "total_money")
    private int total_money;

    @Column(name = "idCus")
    private int idCus;



    public int getIdCus() {
        return idCus;
    }

    public void setIdCus(int idCus) {
        this.idCus = idCus;
    }

    public Cart() {
    }

    public Cart(int id, int idProduct, int idOrder, int price, int amount, int total_money, int idCus) {
        this.id = id;
        this.idProduct = idProduct;
        this.idOrder = idOrder;
        this.price = price;
        this.amount = amount;
        this.total_money = total_money;
        this.idCus = idCus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Integer  getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer  idOrder) {
        this.idOrder = idOrder;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotal_money() {
        return total_money;
    }

    public void setTotal_money(int total_money) {
        this.total_money = total_money;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", idProduct=" + idProduct +
                ", idOrder=" + idOrder +
                ", price=" + price +
                ", amount=" + amount +
                ", total_money=" + total_money +
                ", idCus=" + idCus +
                '}';
    }
}
