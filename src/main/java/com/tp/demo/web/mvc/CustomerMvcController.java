package com.tp.demo.web.mvc;

import com.tp.demo.dao.entities.Customer;
import com.tp.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * In the case of an MVC controller, we use @Controller annotation
 */
@Controller
@RequestMapping("/mvc/customer")
public class CustomerMvcController {

    // Dependency injection
    @Autowired
    @Qualifier("customerServiceImpl")
    private ICustomerService service;

    //Here we return ModelAndView object to springs' dispatcher servlet
    //It will redirect us to the view we set to the ModelAndView object
    // and populate it with the model object that we pass with addObject("attrName", "attrValue") method
    @GetMapping("/all")
    public ModelAndView allCustomers() {
        List<Customer> allCustomers = service.getAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customers-page");
        mv.addObject("customers", allCustomers);
        return mv;
    }
}
