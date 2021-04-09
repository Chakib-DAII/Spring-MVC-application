package com.tp.demo.service;

import com.tp.demo.dao.entities.Customer;
import com.tp.demo.dao.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * A Service class that implements our business logic defined by the CustomerService interface
 */
@Service // used to register our service class as Spring Bean inside the container
public class CustomerServiceImpl implements ICustomerService {

    // Dependency injection via autowiring the repository to the service
    @Autowired
    private ICustomerRepository repository;

    @Override
    public void addCustomer(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        if (customer != null && customer.getId() != null) {
            Optional<Customer> customerFromDB = repository.findById(customer.getId());
            if (customerFromDB.isPresent()) {
                repository.save(customer);
            }
        }
    }

    @Override
    public void deleteCustomer(Long id) {
        if (id != null) {
            repository.deleteById(id);
        }
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }
}
