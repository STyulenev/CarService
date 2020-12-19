package com.carservice.application.service;

import com.carservice.application.data.entity.Detail;
import com.carservice.application.data.entity.Office;
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

}
