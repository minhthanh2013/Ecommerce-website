package com.doan2.spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "idProduct")
    private int idProduct;

    @Column(name = "name")
    private String name;


    @Column(name = "idType")
    private int idType;


    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product() {
    }

    public Product(int idProduct, String name, int idType, int price, String description) {
        this.idProduct = idProduct;
        this.name = name;
        this.idType = idType;
        this.price = price;
        this.description = description;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "idProduct=" + idProduct +
//                ", name='" + name + '\'' +
//                ", idType=" + idType +
//                ", price=" + price +
//                ", description='" + description + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return name;
    }
}
