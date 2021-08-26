package com.doan2.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="tradingPartner_log")
public class TradingPartnerLog {
    @Id
    @Column(name="idLog")
    private int idLog;
    @Column(name="idOrder")
    private int idOrder;
    @Column(name="idPartner")
    private int idPartner;
    @Column(name="date")
    private Date date;
    @Column(name="status")
    private int status;
    @Column(name="total_money")
    private int total_money;

    public TradingPartnerLog() {
    }

    public TradingPartnerLog(int idLog, int idOrder, int idPartner, Date date, int status, int total_money) {
        this.idLog = idLog;
        this.idOrder = idOrder;
        this.idPartner = idPartner;
        this.date = date;
        this.status = status;
        this.total_money = total_money;
    }

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdPartner() {
        return idPartner;
    }

    public void setIdPartner(int idPartner) {
        this.idPartner = idPartner;
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

    public int getTotalMoney() {
        return total_money;
    }

    public void setTotalMoney(int total_money) {
        this.total_money = total_money;
    }

    @Override
    public String toString() {
        return "TradingPartnerLog{" +
                "idLog='" + idLog + '\'' +
                ", idOrder='" + idOrder + '\'' +
                ", idPartner='" + idPartner + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", total_money='" + total_money + '\'' +
                '}';
    }
}