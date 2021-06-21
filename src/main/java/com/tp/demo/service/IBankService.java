package com.tp.demo.service;

import com.tp.demo.dto.BankDTO;

import java.util.List;

public interface IBankService {

    void addBank(BankDTO bank);

    void updateBank(BankDTO bank);

    void deleteBank(Long id);

    List<BankDTO> getAll();
}
