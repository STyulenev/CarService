package com.carservice.application.controllers;

import com.carservice.application.data.entity.Customer;
import com.carservice.application.data.entity.Detail;
import com.carservice.application.service.CustomerService;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public Customer createOrUpdateCustomer(@RequestBody Customer customer) {
        return customerService.createOrUpdateCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }
}
