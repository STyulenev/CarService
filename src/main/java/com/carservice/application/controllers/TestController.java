package com.carservice.application.controllers;

import com.carservice.application.data.entity.Customer;
import com.carservice.application.data.entity.Detail;
import com.carservice.application.data.entity.Office;
import com.carservice.application.data.entity.Warehouse;
import com.carservice.application.service.CustomerService;
import com.carservice.application.service.DetailService;
import com.carservice.application.service.OfficeService;
import com.carservice.application.service.WarehouseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    private final CustomerService customerService;
    private final DetailService detailService;
    private final OfficeService officeService;
    private final WarehouseService warehouseService;


    public TestController(CustomerService customerService, DetailService detailService, OfficeService officeService, WarehouseService warehouseService) {
        this.customerService = customerService;
        this.detailService = detailService;
        this.officeService = officeService;
        this.warehouseService = warehouseService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user")
    public String user() {
       Customer customer = new Customer();
        //customer = customerRepository.findByName("Alexander");
        customer = customerService.findById((long)2);
        return customer.getName() + " " + customer.getPassword() + " " + customer.getRole();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/detail")
    public List<Detail> user2() {
        List<Detail> list = new ArrayList<>();

        list = detailService.findAll();

        return list;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/office")
    public List<Office> user3() {
        List<Office> list = new ArrayList<>();

        list = officeService.findAll();

        return list;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/warehouse")
    public List<Warehouse> user4() {
        List<Warehouse> list = new ArrayList<>();

        // достаёт зациклинные значения
        list = warehouseService.findAll();

        return list;
    }

}
