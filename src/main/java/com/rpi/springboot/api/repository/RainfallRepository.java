package com.rpi.springboot.api.repository;

import com.rpi.springboot.api.entity.Rainfall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RainfallRepository extends JpaRepository<Rainfall, Long> {
}
