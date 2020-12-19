package com.carservice.application.data.repository;

import com.carservice.application.data.entity.Customer;
import com.carservice.application.data.entity.Detail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DetailRepository extends PagingAndSortingRepository<Detail, Long> {
    List<Detail> findAll();

    Detail findByName(String name);
}
