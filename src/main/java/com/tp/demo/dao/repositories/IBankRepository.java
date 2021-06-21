package com.tp.demo.dao.repositories;

import com.tp.demo.dao.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBankRepository extends JpaRepository<Bank,Long> {
    Optional<Bank> findByCode(String code);
}
