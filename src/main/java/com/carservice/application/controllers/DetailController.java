package com.carservice.application.controllers;

import com.carservice.application.data.entity.Detail;
import com.carservice.application.service.DetailService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carservice/detail")
public class DetailController {
    private final DetailService detailService;

    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Detail> GetListDetails() {
        return detailService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Optional<Detail> getDetail(@PathVariable Long id) {
        return detailService.findById(id);
    }
}
