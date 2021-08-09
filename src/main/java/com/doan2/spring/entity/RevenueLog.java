package com.doan2.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "revenue_log")
public class RevenueLog {

    @Column(name = "idCus")
    private int idCus;
    @Column(name = "idOrder")
    private int idOrder;
    @Id
    @Column(name = "idLog")
    private int idLog;
    @Column(name = "date")
    private int date;
    @Column(name = "idMethod")
    private int idMethod;
    @Column(name = "total_money")
    private int total_money;
    @Column(name = "trading_account")
    private String trading_account;

    public RevenueLog() {
    }

    public RevenueLog(int idCus, int idOrder, int idLog, int date, int idMethod, int total_money, String trading_account) {
        this.idCus = idCus;
        this.idOrder = idOrder;
        this.idLog = idLog;
        this.date = date;
        this.idMethod = idMethod;
        this.total_money = total_money;
        this.trading_account = trading_account;
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

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getIdMethod() {
        return idMethod;
    }

    public void setIdMethod(int idMethod) {
        this.idMethod = idMethod;
    }

    public int getTotal_money() {
        return total_money;
    }

    public void setTotal_money(int total_money) {
        this.total_money = total_money;
    }

    public String getTrading_account() {
        return trading_account;
    }

    public void setTrading_account(String trading_account) {
        this.trading_account = trading_account;
    }
}
