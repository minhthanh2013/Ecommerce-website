package com.doan2.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @Column(name = "idCus")
    private int idCus;
    @Column(name = "nameCus")
    private String nameCus;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "dateOfBirth")
    private Date date;
    @Column(name = "bankAccount")
    private String bankAccount;
    @Column(name = "sex")
    private int sex;

    public Customer() {
    }

    public Customer(int idCus, String nameCus, String phone, String email, String address, Date date, String bankAccount, int sex) {
        this.idCus = idCus;
        this.nameCus = nameCus;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.date = date;
        this.bankAccount = bankAccount;
        this.sex = sex;
    }

    public int getIdCus() {
        return idCus;
    }

    public void setIdCus(int idCus) {
        this.idCus = idCus;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return date;
    }

    public void setDob(Date dob) {
        this.date = dob;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCus=" + idCus +
                ", nameCus='" + nameCus + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date +
                ", bankAccount='" + bankAccount + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
