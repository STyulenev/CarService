package com.carservice.application.data.repository;

import com.carservice.application.data.entity.Detail;
import com.carservice.application.data.entity.Office;
import com.carservice.application.data.entity.Warehouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface WarehouseRepository extends PagingAndSortingRepository<Warehouse, Long> {
    List<Warehouse> findAll();


}
