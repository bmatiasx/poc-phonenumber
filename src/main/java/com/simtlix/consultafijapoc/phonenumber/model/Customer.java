package com.simtlix.consultafijapoc.phonenumber.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name = "VW_FIXED_SERVICES", schema = "EBILL")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

    @Id
    @Column(name = "CLT_IDENTIFICATION_NUMBER")
    private Integer dni;

    @Column(name = "CLT_ID")
    private Integer clientId;

    @Column(name = "CLT_NAME")
    private String name;

    @Column(name = "CLT_SURNAME")
    private String surname;

    @Column(name = "ACC_ID")
    private Long accountId;

    @Transient
    private List<Account> accounts;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}
