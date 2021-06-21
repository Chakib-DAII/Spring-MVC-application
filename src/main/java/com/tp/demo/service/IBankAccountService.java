package com.tp.demo.service;

import com.tp.demo.dto.BankAccountDTO;

import java.util.List;

public interface IBankAccountService {


    void addBankAccount(BankAccountDTO bank, String cin);

    void updateBankAccount(BankAccountDTO bank);

    void deleteBankAccount(Long id);

    List<BankAccountDTO> getAll();
}
