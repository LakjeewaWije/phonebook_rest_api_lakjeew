package com.lakjeew.phonebook.models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class User extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uId;
    @NotNull
    private String uFirstname;
    @NotNull
    private String uLasttname;
    @NotNull
    private String uEmail;
    @NotNull
    private String uPhoneno;
    @NotNull
    private String uPassword;

    @OneToMany(mappedBy = "user")
    private List<Contact> contactList;

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getuFirstname() {
        return uFirstname;
    }

    public void setuFirstname(String uFirstname) {
        this.uFirstname = uFirstname;
    }

    public String getuLasttname() {
        return uLasttname;
    }

    public void setuLasttname(String uLasttname) {
        this.uLasttname = uLasttname;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPhoneno() {
        return uPhoneno;
    }

    public void setuPhoneno(String uPhoneno) {
        this.uPhoneno = uPhoneno;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
}
