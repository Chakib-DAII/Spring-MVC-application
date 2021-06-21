package com.tp.demo.dto;

public class BankDTO {
    private Long id;
    private String name;
    private String code;
    private String address;
    private Integer agenciesCount;

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
}
