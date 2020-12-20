package com.carservice.application.data.repository;

import com.carservice.application.data.entity.Detail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface DetailRepository extends PagingAndSortingRepository<Detail, Long> {
    List<Detail> findAll();

    Detail findByName(String name);

    @Query("select d from Detail d where d.id = :id")
    Optional<Detail> findById(Long id);

    void deleteById(Detail detail);
}
