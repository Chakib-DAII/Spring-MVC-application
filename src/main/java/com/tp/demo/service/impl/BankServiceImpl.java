package com.tp.demo.service.impl;

import com.tp.demo.dao.entities.Bank;
import com.tp.demo.dao.repositories.IBankRepository;
import com.tp.demo.dto.BankDTO;
import com.tp.demo.service.IBankService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements IBankService {

    private final IBankRepository bankRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BankServiceImpl(IBankRepository bankRepository, ModelMapper modelMapper) {
        this.bankRepository = bankRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addBank(BankDTO bank) {
        bankRepository.save(modelMapper.map(bank, Bank.class));
    }

    @Override
    public void updateBank(BankDTO bank) {
        if(bank != null && bank.getId() != null)
            bankRepository.save(modelMapper.map(bank, Bank.class));
    }

    @Override
    public void deleteBank(Long id) {
        if(id != null)
            bankRepository.deleteById(id);
    }

    @Override
    public List<BankDTO> getAll() {
        return bankRepository.findAll().stream()
                .map(bank -> modelMapper.map(bank, BankDTO.class))
                .collect(Collectors.toList());
    }
}
