package com.carservice.application.controllers;

import com.carservice.application.data.entity.Detail;
import com.carservice.application.data.entity.Warehouse;
import com.carservice.application.service.OfficeService;
import com.carservice.application.service.WarehouseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Warehouse> list() {
        return warehouseService.findAll();
    }

}
