package com.tp.demo.dao.repositories;

import com.tp.demo.dao.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for our customer entity
 */
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCin(String cin);
}
