package com.carservice.application.controllers;

import com.carservice.application.data.entity.Detail;
import com.carservice.application.data.entity.Office;
import com.carservice.application.service.OfficeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carservice/office")
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Office> listDetails() {
        return officeService.findAll();
    }
}
