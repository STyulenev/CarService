package com.carservice.application.data.repository;

import com.carservice.application.data.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findByName(String name);

    @Query("select d from Customer d where d.id = :id")
    Customer findByIdCustom(Integer id);
}
