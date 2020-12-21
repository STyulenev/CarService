package com.carservice.application.controllers;

import com.carservice.application.configuration.jwt.JwtProvider;
import com.carservice.application.data.dto.CustomerDTO;
import com.carservice.application.data.entity.Customer;
import com.carservice.application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carservice")
public class AuthorizationController {

    private final CustomerService customerService;
    @Autowired
    private JwtProvider jwtProvider;

    public AuthorizationController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/authorization")
    public String createOrUpdateDevice(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerService.findByNameAndPassword(customerDTO.getName(), customerDTO.getPassword());
        String token = jwtProvider.generateToken(customer.getName());
        return token;
    }
}
