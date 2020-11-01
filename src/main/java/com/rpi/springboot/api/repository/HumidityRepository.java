package com.rpi.springboot.api.repository;

import com.rpi.springboot.api.entity.Humidity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumidityRepository extends JpaRepository<Humidity, Long> {
}
