package com.simtlix.consultafijapoc.phonenumber.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "VW_FIXED_SERVICES", schema = "EBILL")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subscription {

    @JsonIgnore
    @Column(name = "ACC_ID")
    private Long accountId;

    @Column(name = "CBT_ID")
    private String serviceTypeId;

    @Column(name = "CBT_DESCRIPTION")
    private String serviceTypeDescription;

    @Column(name = "RATE_PLAN")
    private String plan;

    @Id
    @Column(name = "CLU_CELLULAR_NUMBER")
    private Long cellularNumber;

    @JsonIgnore
    @Column(name = "AAA_ADDRESS_STREET")
    private String street;

    @JsonIgnore
    @Column(name = "AAA_ADDRESS_NUMBER")
    private String number;

    @JsonIgnore
    @Column(name = "AAA_ADDRESS_TOWER")
    private String tower;

    @JsonIgnore
    @Column(name = "AAA_ADDRESS_FLOOR")
    private String floor;

    @JsonIgnore
    @Column(name = "AAA_ADDRESS_FLAT")
    private String flat;

    @JsonIgnore
    @Column(name = "AAA_ADDRESS_WITHIN_STREETS")
    private String withinStreets;

    @JsonIgnore
    @Column(name = "AAA_ADDRESS_CITY")
    private String city;

    @JsonIgnore
    @Column(name = "AAA_ADDRESS_DEPARTMENT")
    private String department;

    @JsonIgnore
    @Column(name = "AAA_CPA")
    private String cp;


    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }
    public Long getAccountId() {
        return accountId;
    }

    public String getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(String serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeDescription() {
        return serviceTypeDescription;
    }

    public void setServiceTypeDescription(String serviceTypeDescription) {
        this.serviceTypeDescription = serviceTypeDescription;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCellularNumber() {
        return cellularNumber;
    }

    public void setCellularNumber(Long cellularNumber) {
        this.cellularNumber = cellularNumber;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTower() {
        return tower;
    }

    public void setTower(String tower) {
        this.tower = tower;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getWithinStreets() {
        return withinStreets;
    }

    public void setWithinStreets(String withinStreets) {
        this.withinStreets = withinStreets;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Subscription)) {
            return false;
        }

        Subscription subscription = (Subscription) o;
        return Objects.equals(accountId, subscription.accountId) &&
                Objects.equals(serviceTypeId, subscription.serviceTypeId) &&
                Objects.equals(serviceTypeDescription, subscription.serviceTypeDescription) &&
                Objects.equals(plan, subscription.plan) &&
                Objects.equals(cellularNumber, subscription.cellularNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, serviceTypeId, serviceTypeDescription, plan);
    }
}
