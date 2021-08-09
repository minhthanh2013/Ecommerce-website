package com.doan2.spring.entity.supportentity;

import javax.validation.constraints.Email;
import java.sql.Date;

public class EditUser {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private int gender;
    @Email(message = "Email should be valid")
    private String email;

    public EditUser() {
    }

    public EditUser(String firstName, String lastName, Date dateOfBirth, int gender, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
