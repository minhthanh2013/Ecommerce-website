package com.doan2.spring.entity.supportentity;
import java.sql.Date;

public class OrderTradingShipping {
    private int idOrder;
    private Date date;
    private String nameSCompany;
    private String namePartner;
    private int totalMoney;
    private String vnTotalMoney;

    public String getVnTotalMoney() {
        return vnTotalMoney;
    }

    public void setVnTotalMoney(String vnTotalMoney) {
        this.vnTotalMoney = vnTotalMoney;
    }

    public OrderTradingShipping() {
    }

    public OrderTradingShipping(int idOrder, Date date, String nameSCompany, String namePartner, int totalMoney) {
        this.idOrder = idOrder;
        this.date = date;
        this.nameSCompany = nameSCompany;
        this.namePartner = namePartner;
        this.totalMoney = totalMoney;
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

    public String getNameSCompany() {
        return nameSCompany;
    }

    public void setNameSCompany(String nameSCompany) {
        this.nameSCompany = nameSCompany;
    }

    public String getNamePartner() {
        return namePartner;
    }

    public void setNamePartner(String namePartner) {
        this.namePartner = namePartner;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
