package com.carservice.application.controllers;

import com.carservice.application.configuration.jwt.JwtProvider;
import com.carservice.application.data.dto.CustomerDTO;
import com.carservice.application.data.entity.Customer;
import com.carservice.application.service.CustomerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carservice")
public class AuthorizationController {

    private final CustomerService customerService;
    private final JwtProvider jwtProvider;

    public AuthorizationController(CustomerService customerService, JwtProvider jwtProvider) {
        this.customerService = customerService;
        this.jwtProvider = jwtProvider;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/authorization")
    public String authorizationCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerService.findByNameAndPassword(customerDTO.getName(), customerDTO.getPassword());
        String token = jwtProvider.generateToken(customer.getName());
        return token;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/registration")
    public String registrationCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setPassword(customerDTO.getPassword());
        customerService.saveCustomer(customer);
        return "OK";
    }
}
