package com.carservice.application.service;

import com.carservice.application.data.entity.Warehouse;
import com.carservice.application.data.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public List<Warehouse> findAll() {
        return warehouseRepository.findAll();
    }

    public List<Warehouse> findByOffice(Long id) {
        return warehouseRepository.findByOffice_id(id);
    }

    public Warehouse findById(Long id) {
        return warehouseRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Warehouse createOrUpdateWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public void deleteWarehouseById(Long id) {
        Warehouse warehouse = findById(id);
        warehouseRepository.delete(warehouse);
    }

}
