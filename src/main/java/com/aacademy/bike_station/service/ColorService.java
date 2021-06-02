package com.aacademy.bike_station.service;


import com.aacademy.bike_station.dto.ColorDto;
import com.aacademy.bike_station.exception.RecordNotFoundException;
import com.aacademy.bike_station.model.Color;
import com.aacademy.bike_station.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class ColorService {

    private final ColorRepository colorRepository;

    @Autowired
    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    public ColorDto findByColor(@NonNull String color) {
        Color wantedColor = colorRepository.findByColor(color)
                .orElseThrow(() ->
                        new RecordNotFoundException(String.format("Color %s not found.", color)));

        return ColorDto.builder()
                .id(wantedColor.getId())
                .color(wantedColor.getColor())
                .build();
    }
}
