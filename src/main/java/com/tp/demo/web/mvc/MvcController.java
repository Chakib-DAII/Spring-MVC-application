package com.tp.demo.web.mvc;

import com.tp.demo.dto.BankAccountDTO;
import com.tp.demo.dto.BankDTO;
import com.tp.demo.dto.CustomerDTO;
import com.tp.demo.service.IBankAccountService;
import com.tp.demo.service.IBankService;
import com.tp.demo.service.ICustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class MvcController {

    private final IBankService bankService;
    private final ICustomerService customerService;
    private final IBankAccountService bankAccountService;

    @Autowired
    public MvcController(IBankService bankService, ICustomerService customerService,
                         IBankAccountService bankAccountService) {
        this.bankService = bankService;
        this.customerService = customerService;
        this.bankAccountService = bankAccountService;
    }

    @GetMapping(value = { "/", "/index" })
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @GetMapping(value = "/login")
    public ModelAndView loginPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @GetMapping(value = "/403")
    public ModelAndView accessDenied(Principal principal) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("403");
        if (principal != null) {
            mv.addObject("message", "Hi " + principal.getName()
                    + "<br> You do not have permission to access this page!");
        } else {
            mv.addObject("msg",
                    "You do not have permission to access this page!");
        }
        return mv;
    }

    @GetMapping("/customer/all")
    public ModelAndView allCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customers-page");
        mv.addObject("customers", allCustomers);
        return mv;
    }

    @GetMapping("/bank/all")
    public ModelAndView allBanks() {
        List<BankDTO> allBanks = bankService.getAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("banks-page");
        mv.addObject("banks", allBanks);
        return mv;
    }

    @GetMapping("/bank-account/all")
    public ModelAndView allBankAccounts() {
        List<BankAccountDTO> allBankAccounts = bankAccountService.getAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("bank-accounts-page");
        mv.addObject("bankAccounts", allBankAccounts);
        return mv;
    }
}
