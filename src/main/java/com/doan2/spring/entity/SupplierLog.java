package com.doan2.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
@Entity
@Table (name = "supplier_log")
public class SupplierLog {
    @Id
    @Column(name = "idLog")
    private int idLog;
    @Column(name = "idOrder")
    private int idOrder;
    @Column(name = "date")
    private Date date;
    @Column (name = "status")
    private int status;
    @Column (name = "total_money")
    private int totalMoney;
    @Column (name = "idSup")
    private int idSup;
    public SupplierLog() {
    }

    public SupplierLog(int idLog, int idOrder, Date date, int status, int totalMoney, int idSup) {
        this.idLog = idLog;
        this.idOrder = idOrder;
        this.date = date;
        this.status = status;
        this.totalMoney = totalMoney;
        this.idSup = idSup;
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
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getIdSup() {
        return idSup;
    }

    public void setIdSup(int idSup) {
        this.idSup = idSup;
    }

    @Override
    public String toString() {
        return "SupplierLog{" +
                "idLog='" + idLog + '\'' +
                ", idOrder='" + idOrder + '\'' +
                ", date=" + date +
                ", status=" + status +
                ", totalMoney=" + totalMoney +
                ", idSup='" + idSup + '\'' +
                '}';
    }
}
