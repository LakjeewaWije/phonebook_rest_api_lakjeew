package com.lakjeew.phonebook.models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Contact extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cId;

    @NotNull
    private String cName;

    @NotNull
    private String cMobile;


    private String cOffice;


    private String cHome;


    private String cEmail;

    @ManyToOne
    private User user;

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcMobile() {
        return cMobile;
    }

    public void setcMobile(String cMobile) {
        this.cMobile = cMobile;
    }

    public String getcOffice() {
        return cOffice;
    }

    public void setcOffice(String cOffice) {
        this.cOffice = cOffice;
    }

    public String getcHome() {
        return cHome;
    }

    public void setcHome(String cHome) {
        this.cHome = cHome;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
