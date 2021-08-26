package com.doan2.spring.entity.supportentity;

import com.doan2.spring.entity.Product;

import java.math.BigDecimal;

public class SupplierInfo {
    private int idSup;
    private String nameSup;
    private String address;
    private BigDecimal monthlyRevenue; //x
    private BigDecimal totalRevenue; //x
    private double rate; //
    private String vnTotalMoneyMonth;
    private String vnTotalMoneyTotal;

    public String getVnTotalMoneyMonth() {
        return vnTotalMoneyMonth;
    }

    public void setVnTotalMoneyMonth(String vnTotalMoneyMonth) {
        this.vnTotalMoneyMonth = vnTotalMoneyMonth;
    }

    public String getVnTotalMoneyTotal() {
        return vnTotalMoneyTotal;
    }

    public void setVnTotalMoneyTotal(String vnTotalMoneyTotal) {
        this.vnTotalMoneyTotal = vnTotalMoneyTotal;
    }

    public SupplierInfo() {
    }

    public SupplierInfo(String nameSup, String address, BigDecimal monthlyRevenue, BigDecimal totalRevenue, double rate) {
        this.nameSup = nameSup;
        this.address = address;
        this.monthlyRevenue = monthlyRevenue;
        this.totalRevenue = totalRevenue;
        this.rate = rate;

    }

    public int getIdSup() {
        return idSup;
    }

    public void setIdSup(int idSup) {
        this.idSup = idSup;
    }

    public String getNameSup() {
        return nameSup;
    }

    public void setNameSup(String nameSup) {
        this.nameSup = nameSup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getMonthlyRevenue() {
        return monthlyRevenue;
    }

    public void setMonthlyRevenue(BigDecimal monthlyRevenue) {
        this.monthlyRevenue = monthlyRevenue;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "SupplierInfo{" +
                "nameSup='" + nameSup + '\'' +
                ", address='" + address + '\'' +
                ", monthlyRevenue=" + monthlyRevenue +
                ", totalRevenue=" + totalRevenue +
                ", rate=" + rate +
                '}';
    }
}
