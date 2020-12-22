package com.carservice.application.service;

import com.carservice.application.data.entity.Customer;
import com.carservice.application.data.repository.CustomerRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Customer createOrUpdateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer saveCustomer(Customer customer) {
        customer.setRole("ROLE_USER");
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

    public void deleteCustomerById(Long id) {
        var customer = findById(id);
        customerRepository.deleteById(id);
    }

    public Customer findByName(String name) {
        return customerRepository.findByName(name);
    }

    public Customer findByNameAndPassword(String name, String password) {
        //return customerRepository.findByNameAndPassword(name, password);

        var customer = findByName(name);

        if (customer != null) {
            if (passwordEncoder.matches(password, customer.getPassword())) {
                return customer;
            }
        }

        return null;
    }
}
