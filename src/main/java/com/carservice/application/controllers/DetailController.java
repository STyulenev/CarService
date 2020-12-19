package com.carservice.application.controllers;

import com.carservice.application.data.entity.Customer;
import com.carservice.application.data.entity.Detail;
import com.carservice.application.service.DetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carservice/detail")
public class DetailController {
    private final DetailService detailService;

    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listdetails")
    public List<Detail> listDetails() {
        return detailService.findAll();
    }
}
