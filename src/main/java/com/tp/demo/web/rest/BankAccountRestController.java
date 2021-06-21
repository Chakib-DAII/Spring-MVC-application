package com.tp.demo.web.rest;

import com.tp.demo.dto.BankAccountDTO;
import com.tp.demo.service.IBankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/bank-account")
public class BankAccountRestController {

    private final IBankAccountService service;

    @Autowired
    public BankAccountRestController(IBankAccountService service) {
        this.service = service;
    }

    //@RequestBody annotation to indicate that the the request object could be found in the HttpRequest body
    @PostMapping("/add")
    public void createBankAccount(@RequestBody BankAccountDTO bankAccount, @RequestParam("customer-cin") String cin) {
        service.addBankAccount(bankAccount, cin);
    }

    @PutMapping("/update")
    public void updateBankAccount(@RequestBody BankAccountDTO bankAccount) {
        service.updateBankAccount(bankAccount);
    }

    @DeleteMapping("/delete")
    public void deleteBankAccount(@RequestParam("idAccount") Long id) {
        service.deleteBankAccount(id);
    }

    @GetMapping("/all")
    public List<BankAccountDTO> getAll() {
        return service.getAll();
    }
}
