package com.carservice.application.controllers;

import com.carservice.application.data.entity.Office;
import com.carservice.application.service.OfficeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carservice/office")
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Office> listOffices() {
        return officeService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list/{city}")
    public List<Office> listOfficesByCity(@PathVariable String city) {
        return officeService.findByCity(city);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public Office createOrUpdateOffices(@RequestBody Office office) {
        return officeService.createOrUpdateOffice(office);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void deleteOffice(@PathVariable Long id) {
        officeService.deleteOfficeById(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Office getOffice(@PathVariable Long id) {
        return officeService.findById(id);
    }
}
