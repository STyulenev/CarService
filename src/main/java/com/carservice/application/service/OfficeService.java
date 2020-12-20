package com.carservice.application.service;

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

    public Office findByCityAndAddress(String city, String address) {
        return officeRepository.findByCityAndAddress(city, address);
    }

    public List<Office> findByCity(String city) {
        return officeRepository.findByCity(city);
    }

    public Office findById(Long id) {
        return officeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public  Office createOrUpdateOffice(Office office) {
        return officeRepository.save(office);
    }

    public void deleteOfficeById(Long id) {
        Office office = findById(id);
        officeRepository.delete(office);
    }
}
