package com.carservice.application.configuration;

import com.carservice.application.data.entity.Customer;
import com.carservice.application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private CustomerService customerService;

    @Override
    public CustomUserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Customer customer = customerService.findByName(name);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(customer);
    }
}
