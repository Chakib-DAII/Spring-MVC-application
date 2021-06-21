package com.tp.demo.service.impl;

import com.tp.demo.dao.entities.Bank;
import com.tp.demo.dao.entities.Customer;
import com.tp.demo.dao.repositories.IBankRepository;
import com.tp.demo.dao.repositories.ICustomerRepository;
import com.tp.demo.dto.CustomerDTO;
import com.tp.demo.service.ICustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * A Service class that implements our business logic defined by the CustomerService interface
 */
@Service // used to register our service class as Spring Bean inside the container
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerRepository customerRepository;
    private final IBankRepository bankRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerServiceImpl(ICustomerRepository customerRepository, IBankRepository bankRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.bankRepository = bankRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addCustomer(CustomerDTO customer, String bankCode) {
        if (!StringUtils.isEmpty(bankCode)){
            Optional<Bank> bank = bankRepository.findByCode(bankCode);
            if(bank.isPresent()){
                Customer customerDb = modelMapper.map(customer, Customer.class);
                customerDb.setBank(bank.get());
                customerRepository.save(customerDb);
            }
        }
    }

    @Override
    public void updateCustomer(CustomerDTO customer) {
        if (customer != null && customer.getId() != null) {
            Optional<Customer> customerFromDB = customerRepository.findById(customer.getId());
            if (customerFromDB.isPresent()) {
                customerRepository.save(modelMapper.map(customer, Customer.class));
            }
        }
    }

    @Override
    public void deleteCustomer(Long id) {
        if (id != null) {
            customerRepository.deleteById(id);
        }
    }

    @Override
    public List<CustomerDTO> getAll() {
        return customerRepository.findAll().stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }
}
