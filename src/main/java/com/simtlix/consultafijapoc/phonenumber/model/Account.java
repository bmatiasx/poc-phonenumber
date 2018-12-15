package com.simtlix.consultafijapoc.phonenumber.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Account {

    @Id
    @Column(name = "ACC_ID")
    private Long accountId;

    @JsonIgnore
    @Column(name = "CLT_ID")
    private Integer clientId;

    @Transient
    private List<Address> addresses;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
