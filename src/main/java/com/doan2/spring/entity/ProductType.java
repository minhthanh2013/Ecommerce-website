package com.doan2.spring.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProductType")
public class ProductType {
    @Id
    @Column(name = "idType")
    private int idType;
    @Column(name = "nameType")
    private String nameType;

    public ProductType() {
    }

    public ProductType(int idType, String nameType) {
        this.idType = idType;
        this.nameType = nameType;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "idType=" + idType +
                ", nameType='" + nameType + '\'' +
                '}';
    }
}
