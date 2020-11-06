package com.sayone.online.entity;

import javax.persistence.*;

@Entity
@Table(name="country")
public class Country {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name",nullable = false)
    private String name ;

    @Column(name="code",nullable = false)
    private String code ;

    @Column(name="currency",nullable = false)
    private String currency ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


}
