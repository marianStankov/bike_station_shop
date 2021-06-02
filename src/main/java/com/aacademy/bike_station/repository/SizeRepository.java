package com.aacademy.bike_station.repository;

import com.aacademy.bike_station.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SizeRepository extends JpaRepository<Size, Long> {

    Optional<Size> findBySize(Integer size);
}
