package com.doan2.spring.entity.supportentity;

public class ProductTypeCungCap {
    private int idType;
    private String nameType;
    private int amount;

    public ProductTypeCungCap(int idType, String nameType, int amount) {
        this.idType = idType;
        this.nameType = nameType;
        this.amount = amount;
    }

    public ProductTypeCungCap() {
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
