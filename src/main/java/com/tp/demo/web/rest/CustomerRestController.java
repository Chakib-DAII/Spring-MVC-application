package com.tp.demo.web.rest;

import com.tp.demo.dao.entities.Customer;
import com.tp.demo.dto.CustomerDTO;
import com.tp.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/customer")
public class CustomerRestController {

    // Dependency injection: Autowiring the service bean to the controller bean
    @Autowired
    // The qualifier annotation is used when we have more than one bean of the same type
    // we need to specify the bean name that we want to inject
    @Qualifier("customerServiceImpl")
    private ICustomerService service;

    //@RequestBody annotation to indicate that the the request object could be found in the HttpRequest body
    @PostMapping("/add")
    public void createCustomer(@RequestBody CustomerDTO customer) {
        service.addCustomer(CustomerDTO.fromDtoToEntity(customer));
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestBody Customer customer) {
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
    public List<Customer> getAll() {
        return service.getAll();
    }
}
