package com.lakjeew.phonebook.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class User extends com.avaje.ebean.Model  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long U_id;
    @NotNull
    private String U_username;
    @NotNull
    private String U_email;
    @NotNull
    private String U_phone;
    @NotNull
    private String U_password;

    @OneToMany(mappedBy = "user")
    private List<Contact> contactList;

    public Long getU_id() {
        return U_id;
    }

    public void setU_id(Long u_id) {
        U_id = u_id;
    }

    public String getU_username() {
        return U_username;
    }

    public void setU_username(String u_username) {
        U_username = u_username;
    }

    public String getU_email() {
        return U_email;
    }

    public void setU_email(String u_email) {
        U_email = u_email;
    }

    public String getU_phone() {
        return U_phone;
    }

    public void setU_phone(String u_phone) {
        U_phone = u_phone;
    }

    public String getU_password() {
        return U_password;
    }

    public void setU_password(String u_password) {
        U_password = u_password;
    }
}
