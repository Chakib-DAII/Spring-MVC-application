package com.tp.demo.service.impl;

import com.tp.demo.dao.entities.BankAccount;
import com.tp.demo.dao.entities.Customer;
import com.tp.demo.dao.repositories.IBankAccountRepository;
import com.tp.demo.dao.repositories.ICustomerRepository;
import com.tp.demo.dto.BankAccountDTO;
import com.tp.demo.service.IBankAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankAccountServiceImpl implements IBankAccountService {

    private final IBankAccountRepository bankAccountRepository;
    private final ICustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BankAccountServiceImpl(IBankAccountRepository bankAccountRepository, ICustomerRepository customerRepository, ModelMapper modelMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addBankAccount(BankAccountDTO bankAccount, String cin) {
        if (!StringUtils.isEmpty(cin)){
            Optional<Customer> customer = customerRepository.findByCin(cin);
            if(customer.isPresent()){
                BankAccount bankAccountDb = modelMapper.map(bankAccount, BankAccount.class);
                bankAccountDb.setCustomer(customer.get());
                bankAccountRepository.save(bankAccountDb);
            }
        }
    }

    @Override
    public void updateBankAccount(BankAccountDTO bankAccount) {
        if(bankAccount != null && bankAccount.getId() != null)
            bankAccountRepository.save(modelMapper.map(bankAccount, BankAccount.class));
    }

    @Override
    public void deleteBankAccount(Long id) {
        if(id != null)
            bankAccountRepository.deleteById(id);
    }

    @Override
    public List<BankAccountDTO> getAll() {
        return bankAccountRepository.findAll().stream()
                .map(bankAccount -> modelMapper.map(bankAccount, BankAccountDTO.class))
                .collect(Collectors.toList());
    }
}
