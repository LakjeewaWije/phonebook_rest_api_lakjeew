package com.lakjeew.phonebook.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Contact extends com.avaje.ebean.Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long C_id;

    @NotNull
    private String C_name;

    @NotNull
    private String C_mobile;

    @NotNull
    private String C_Email;

    @ManyToOne
    private User user;

    public Long getC_id() {
        return C_id;
    }

    public void setC_id(Long c_id) {
        C_id = c_id;
    }

    public String getC_name() {
        return C_name;
    }

    public void setC_name(String c_name) {
        C_name = c_name;
    }

    public String getC_mobile() {
        return C_mobile;
    }

    public void setC_mobile(String c_mobile) {
        C_mobile = c_mobile;
    }

    public String getC_Email() {
        return C_Email;
    }

    public void setC_Email(String c_Email) {
        C_Email = c_Email;
    }
}
