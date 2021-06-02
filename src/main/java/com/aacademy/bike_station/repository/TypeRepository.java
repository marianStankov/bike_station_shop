package com.aacademy.bike_station.repository;

import com.aacademy.bike_station.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {

    Optional<Type> findByType(String type);
}
