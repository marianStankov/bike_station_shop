package com.aacademy.bike_station.controller;

import com.aacademy.bike_station.dto.BikeDto;
import com.aacademy.bike_station.service.BikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bikes")
public class BikeController {

    private final BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> save(@RequestBody BikeDto bikeDto) {
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BikeDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bikeService.findById(id));
    }
}
