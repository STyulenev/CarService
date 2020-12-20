package com.carservice.application.service;

import com.carservice.application.data.entity.Detail;
import com.carservice.application.data.repository.DetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailService {
    private final DetailRepository detailRepository;

    public DetailService(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    public List<Detail> findAll() {
        return detailRepository.findAll();
    }

    public Optional<Detail> findById(Long id) {
        return detailRepository.findById(id);
    }
}
