/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_mvc_sampleform.entity;

import com.mycompany.pr31_jv37_spring_mvc_sampleform.emuns.Gender;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author XV
 */
@Entity
@Table(name = "account")
public class AccountEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name", length = 100)
    @NotBlank(message = "This feild is required")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "This field incorrect syntax")
    private String fullName;

    @Column(nullable = false)
    @NotBlank(message = " This feild is required ")
    @Size(min = 5, max = 100)
    private String passWork;

    @Column(nullable = false)
    @NotBlank(message = " This feild is required ")
    @Email(message = " The email incorrect syntac ")
    private String email;

    @Column(length = 1000)
    private String description;

    private String country;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthDate;

    private boolean smoking;

    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.Male;

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassWork() {
        return passWork;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public String getCountry() {
        return country;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public Gender getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassWork(String passWork) {
        this.passWork = passWork;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "AccountEntity{" + "id=" + id + ", fullName=" + fullName + ", passWork=" + passWork + ", email=" + email + ", description=" + description + ", country=" + country + ", birthDate=" + birthDate + ", smoking=" + smoking + ", gender=" + gender + '}';
    }

}
