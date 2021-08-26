package com.doan2.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Supplier")
public class Supplier {
    @Id
    @Column(name = "idSup")
    private int idSup;
    @Column(name = "nameSup")
    private String nameSup;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "bankAccount")
    private String bankAccount;


    public Supplier() {
    }

    public Supplier(int idSup, String nameSup, String address, String phone, String email, String bankAccount) {
        this.idSup = idSup;
        this.nameSup = nameSup;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.bankAccount = bankAccount;
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

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "idSup=" + idSup +
                ", nameSup='" + nameSup + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                '}';
    }
}
