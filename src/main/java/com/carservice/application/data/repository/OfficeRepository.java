package com.carservice.application.data.repository;

import com.carservice.application.data.entity.Office;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface OfficeRepository extends PagingAndSortingRepository<Office, Long> {
    List<Office> findAll();

    List<Office> findByCity(String city);

    Office findByCityAndAddress(String city, String address);

    @Query("select o from Office o where o.id = :id")
    Optional<Office> findById(Long id);

    void delete(Office office);
}
