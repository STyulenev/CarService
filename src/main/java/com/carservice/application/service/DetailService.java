package com.carservice.application.service;

import com.carservice.application.data.entity.Customer;
import com.carservice.application.data.entity.Detail;
import com.carservice.application.data.repository.DetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailService {
    private final DetailRepository detailRepository;

    public DetailService(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    public List<Detail> findAll() {
        return detailRepository.findAll();
    }
}
