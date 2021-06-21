package com.tp.demo.web.rest;

import com.tp.demo.dto.CustomerDTO;
import com.tp.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/customer")
public class CustomerRestController {

    private final ICustomerService service;

    @Autowired
    public CustomerRestController(ICustomerService service) {
        this.service = service;
    }

    //@RequestBody annotation to indicate that the the request object could be found in the HttpRequest body
    @PostMapping("/add")
    public void createCustomer(@RequestBody CustomerDTO customer, @RequestParam("bank-code") String bankCode) {
        service.addCustomer(customer, bankCode);
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestBody CustomerDTO customer) {
        service.updateCustomer(customer);
    }

    //@PathVariable annotation is used when we want to pass the parameter as a url variable: /delete/'param'
    @DeleteMapping("/delete/{idCustomer}")
    public void deleteCustomer(@PathVariable("idCustomer") Long id) {
        service.deleteCustomer(id);
    }

    //@RequestParam annotation is used when we want to pass the parameter as a url param: /delete?idCustomer=...
    @DeleteMapping("/delete")
    public void deleteCustomer2(@RequestParam("idCustomer") Long id) {
        service.deleteCustomer(id);
    }

    @GetMapping("/all")
    public List<CustomerDTO> getAll() {
        return service.getAll();
    }
}
