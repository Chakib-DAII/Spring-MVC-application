package com.tp.demo.service;

import com.tp.demo.dto.CustomerDTO;

import java.util.List;


/**
 * We use interfaces to declare our service methods that should provide our business layer
 */
public interface ICustomerService {

    void addCustomer(CustomerDTO customer, String bankCode);

    void updateCustomer(CustomerDTO customer);

    void deleteCustomer(Long id);

    List<CustomerDTO> getAll();
}
