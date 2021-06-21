package com.tp.demo.dao.repositories;

import com.tp.demo.dao.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBankAccountRepository extends JpaRepository<BankAccount,Long> {
}
