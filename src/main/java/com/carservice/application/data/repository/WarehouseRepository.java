package com.carservice.application.data.repository;

import com.carservice.application.data.entity.Warehouse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface WarehouseRepository extends PagingAndSortingRepository<Warehouse, Long> {
    List<Warehouse> findAll();

    List<Warehouse> findByOffice_id(Long id);

    @Query("select w from Warehouse w where w.id = :id")
    Optional<Warehouse> findById(Long id);
}
