package com.tp.demo.dao.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Bank {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(unique = true)
    private String code;
    private String address;
    private Integer agenciesCount;
    @OneToMany(mappedBy = "bank", targetEntity = Customer.class, orphanRemoval = true)
    private Set<Customer> customers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAgenciesCount() {
        return agenciesCount;
    }

    public void setAgenciesCount(Integer agenciesCount) {
        this.agenciesCount = agenciesCount;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
