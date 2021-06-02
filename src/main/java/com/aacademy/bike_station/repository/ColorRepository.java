package com.aacademy.bike_station.repository;

import com.aacademy.bike_station.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColorRepository extends JpaRepository<Color, Long> {

    Optional<Color> findByColor(String color);
}
