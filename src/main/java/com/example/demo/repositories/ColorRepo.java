package com.example.demo.repositories;


import com.example.demo.entity.Color;
import com.example.demo.entity.propertis.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorRepo extends JpaRepository<Color, Long> {


    @Query(value = "select c from Color c where c.status = 'DANG_HOAT_DONG'")
    List<Color> getAll();

    Page<Color> getAllByStatus(Status status, Pageable pageable);


}
