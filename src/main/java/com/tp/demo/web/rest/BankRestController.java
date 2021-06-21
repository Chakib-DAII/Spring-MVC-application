package com.tp.demo.web.rest;

import com.tp.demo.dto.BankDTO;
import com.tp.demo.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/bank")
public class BankRestController {

    private final IBankService service;

    @Autowired
    public BankRestController(IBankService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public void createBank(@RequestBody BankDTO bank) {
        service.addBank(bank);
    }

    @PutMapping("/update")
    public void updateBank(@RequestBody BankDTO bank) {
        service.updateBank(bank);
    }

    @DeleteMapping("/delete/{idBank}")
    public void deleteBank(@PathVariable("idBank") Long id) {
        service.deleteBank(id);
    }

    @GetMapping("/all")
    public List<BankDTO> getAll() {
        return service.getAll();
    }
}
