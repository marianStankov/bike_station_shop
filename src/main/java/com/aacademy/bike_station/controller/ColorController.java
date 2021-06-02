package com.aacademy.bike_station.controller;

import com.aacademy.bike_station.dto.ColorDto;
import com.aacademy.bike_station.service.ColorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/colors")
public class ColorController {

    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping(value = "/{colors}")
    public ResponseEntity<ColorDto> findByColor(@PathVariable String color) {
        return ResponseEntity.ok(colorService.findByColor(color));
    }
}
