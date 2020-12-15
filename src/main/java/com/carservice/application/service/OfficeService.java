package com.carservice.application.service;

import com.carservice.application.data.entity.Detail;
import com.carservice.application.data.entity.Office;
import com.carservice.application.data.repository.OfficeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeService {
    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public List<Office> findAll() {
        return officeRepository.findAll();
    }
}
