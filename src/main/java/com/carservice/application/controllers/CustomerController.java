package com.carservice.application.controllers;

import com.carservice.application.data.entity.Customer;
import com.carservice.application.service.CustomerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carservice/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.findById(id);
    }
}
