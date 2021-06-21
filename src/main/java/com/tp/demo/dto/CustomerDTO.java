package com.tp.demo.dto;

import java.util.Date;

/**
 * Data Transfer Object :
 * It's a representation for our entity.
 *
 * Note: When using DTO objects, we certainly need to introduce 2 methods called "MappingMethods"
 *       used in order to transform an entity to a DTO and a DTO to an entity
 */
public class CustomerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String cin;
    private Date birthDate;
    private String email;
    private String telephone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
