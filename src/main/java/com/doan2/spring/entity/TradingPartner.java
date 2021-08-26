package com.doan2.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
@Entity
@Table(name = "trading_partner")
public class TradingPartner {
    @Id
    @Column(name = "idPartner")
    private int idPartner;
    @Column(name = "trading_account")
    private int tradingAccount;
    @Column(name = "cooperation_date")
    private Date cooperationDate;
    @Column(name = "idMethod")
    private int idMethod;
    @Column(name = "namePartner")
    private String namePartner;

    public TradingPartner() {
    }

    public TradingPartner(int idPartner, int tradingAccount, Date cooperationDate, int idMethod, String namePartner) {
        this.idPartner = idPartner;
        this.tradingAccount = tradingAccount;
        this.cooperationDate = cooperationDate;
        this.idMethod = idMethod;
        this.namePartner = namePartner;
    }

    public int getIdPartner() {
        return idPartner;
    }

    public void setIdPartner(int idPartner) {
        this.idPartner = idPartner;
    }

    public int getTradingAccount() {
        return tradingAccount;
    }

    public void setTradingAccount(int tradingAccount) {
        this.tradingAccount = tradingAccount;
    }

    public Date getCooperationDate() {
        return cooperationDate;
    }

    public void setCooperationDate(Date cooperationDate) {
        this.cooperationDate = cooperationDate;
    }

    public int getIdMethod() {
        return idMethod;
    }

    public void setIdMethod(int idMethod) {
        this.idMethod = idMethod;
    }

    public String getNamePartner() {
        return namePartner;
    }

    public void setNamePartner(String namePartner) {
        this.namePartner = namePartner;
    }

    @Override
    public String toString() {
        return "TradingPartner{" +
                "idPartner='" + idPartner + '\'' +
                ", tradingAccount=" + tradingAccount +
                ", cooperationDate=" + cooperationDate +
                ", idMethod='" + idMethod + '\'' +
                ", namePartner='" + namePartner + '\'' +
                '}';
    }
}
