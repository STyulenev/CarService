package com.carservice.application.data.repository;

import com.carservice.application.data.entity.Detail;
import com.carservice.application.data.entity.Office;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface OfficeRepository extends PagingAndSortingRepository<Office, Long> {
    List<Office> findAll();

    @Query("select o from Office o where o.id = :id")
    Office findByOne(Long id);
}
