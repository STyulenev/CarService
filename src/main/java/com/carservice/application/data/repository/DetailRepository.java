package com.carservice.application.data.repository;

import com.carservice.application.data.entity.Customer;
import com.carservice.application.data.entity.Detail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetailRepository extends CrudRepository<Detail, Long> {
    List<Detail> findAll();
}
