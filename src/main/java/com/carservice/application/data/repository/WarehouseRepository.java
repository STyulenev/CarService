package com.carservice.application.data.repository;

import com.carservice.application.data.entity.Office;
import com.carservice.application.data.entity.Warehouse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WarehouseRepository extends CrudRepository<Warehouse, Long> {
    List<Warehouse> findAll();
}
