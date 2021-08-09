package com.doan2.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "CungCap")
public class CungCap {
    @Id
    @Column(name = "idProduct")
    private int idProduct;
    @Column(name = "idSup")
    private int idSup;
    @Column(name = "inventory")
    private int inventory;

    public CungCap() {
    }

    public CungCap(int idProduct, int idSup, int inventory) {
        this.idProduct = idProduct;
        this.idSup = idSup;
        this.inventory = inventory;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdSup() {
        return idSup;
    }

    public void setIdSup(int idSup) {
        this.idSup = idSup;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "CungCap{" +
                "idProduct=" + idProduct +
                ", idSup=" + idSup +
                ", inventory=" + inventory +
                '}';
    }
}
