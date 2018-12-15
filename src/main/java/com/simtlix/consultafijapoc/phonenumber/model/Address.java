package com.simtlix.consultafijapoc.phonenumber.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "VW_FIXED_SERVICES", schema = "EBILL")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {


    @Column(name = "ACC_ID")
    @JsonIgnore
    private Long accountId;

    @Id
    @Column(name = "CLU_CELLULAR_NUMBER")
    @JsonIgnore
    private Long cellularNumber;

    @Column(name = "AAA_ADDRESS_STREET")
    private String street;

    @Column(name = "AAA_ADDRESS_NUMBER")
    private String number;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "AAA_ADDRESS_TOWER")
    private String tower;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "AAA_ADDRESS_FLOOR")
    private String floor;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "AAA_ADDRESS_FLAT")
    private String flat;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "AAA_ADDRESS_WITHIN_STREETS")
    private String withinStreets;

    @Column(name = "AAA_ADDRESS_CITY")
    private String city;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "AAA_ADDRESS_DEPARTMENT")
    private String department;

    @Column(name = "AAA_CPA")
    private String cp;

    @Transient
    private Set<Subscription> subscriptions;

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

    public Set<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Address)) {
            return false;
        }

        Address address = (Address) o;
        return Objects.equals(accountId, address.accountId) &&
                Objects.equals(street, address.street) &&
                Objects.equals(number, address.number) &&
                Objects.equals(tower, address.tower) &&
                Objects.equals(floor, address.floor) &&
                Objects.equals(flat, address.flat) &&
                Objects.equals(withinStreets, address.withinStreets) &&
                Objects.equals(city, address.city) &&
                Objects.equals(department, address.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, street, number, tower, floor, flat, withinStreets, city, department);
    }

}
