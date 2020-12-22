package com.carservice.application.controllers;

import com.carservice.application.data.entity.Detail;
import com.carservice.application.service.DetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carservice/detail")
public class DetailController {
    private final DetailService detailService;

    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get/list")
    public List<Detail> GetListDetails() {
        return detailService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get/name/{name}")
    public Detail GetNameDetail(@PathVariable String name) {
        return detailService.findByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get/{id}")
    public Optional<Detail> getDetail(@PathVariable Long id) {
        return detailService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/update")
    public Detail createOrUpdateDevice(@RequestBody Detail detail) {
        return detailService.createOrUpdateDetail(detail);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/update/{id}")
    public void deleteDetail(@PathVariable Long id) {
        detailService.deleteDetailById(id);
    }
}
