package com.carservice.application.controllers;

import com.carservice.application.data.entity.Warehouse;
import com.carservice.application.service.OfficeService;
import com.carservice.application.service.WarehouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carservice/warehouse")
public class WarehouseController {

    private final WarehouseService warehouseService;
    private final OfficeService officeService;

    public WarehouseController(WarehouseService warehouseService, OfficeService officeService) {
        this.warehouseService = warehouseService;
        this.officeService = officeService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get/{city}/{address}")
    public List<Warehouse> listWarehouseByOffice(@PathVariable String city,
                                                 @PathVariable String address) {
        var office = officeService.findByCityAndAddress(city, address);
        return warehouseService.findByOffice(office.getId());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get/list")
    public List<Warehouse> listWarehouse() {
        return warehouseService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/update/")
    public Warehouse createOrUpdateWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseService.createOrUpdateWarehouse(warehouse);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/update/{id}")
    public void deleteWarehouse(@PathVariable Long id) {
        warehouseService.deleteWarehouseById(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get/{id}")
    public Warehouse getWarehouse(@PathVariable Long id) {
        return warehouseService.findById(id);
    }
}
