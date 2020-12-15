package com.carservice.application.data.repository;

import com.carservice.application.data.entity.Detail;
import com.carservice.application.data.entity.Office;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfficeRepository extends CrudRepository<Office, Long> {
    List<Office> findAll();
}
