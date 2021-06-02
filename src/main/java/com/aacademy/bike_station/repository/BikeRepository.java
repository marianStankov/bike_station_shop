package com.aacademy.bike_station.repository;

import com.aacademy.bike_station.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Long> {

}
