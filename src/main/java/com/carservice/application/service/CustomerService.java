package com.carservice.application.service;

import com.carservice.application.data.entity.Customer;
import com.carservice.application.data.entity.Detail;
import com.carservice.application.data.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Customer createOrUpdateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomerById(Long id) {
        var customer = findById(id);
        customerRepository.deleteById(id);
    }
}
