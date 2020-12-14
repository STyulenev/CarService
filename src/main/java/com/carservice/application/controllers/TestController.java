package com.carservice.application.controllers;

import com.carservice.application.data.entity.Customer;
import com.carservice.application.data.repository.CustomerRepository;
import com.carservice.application.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public TestController(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user")
    public String user() {
       Customer customer = new Customer();
        //customer = customerRepository.findByName("Alexander");
        customer = customerRepository.findByIdCustom(2);
        return customer.getName() + " " + customer.getPassword() + " " + customer.getRole();
    }
}
