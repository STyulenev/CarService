package com.carservice.application.data.repository;

import com.carservice.application.data.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByName(String name);

    @Query("select d from Customer d where d.id = :id")
    Customer findByIdCustom(Long id);

    Customer findByNameAndPassword(String name, String password);
}
