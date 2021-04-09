package com.tp.demo.service;

import com.tp.demo.dao.entities.Customer;

import java.util.List;


/**
 * We use interfaces to declare our service methods that should provide our business layer
 */
public interface ICustomerService {

    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Long id);

    List<Customer> getAll();
}
