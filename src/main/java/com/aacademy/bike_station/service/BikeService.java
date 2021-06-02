package com.aacademy.bike_station.service;

import com.aacademy.bike_station.dto.BikeDto;
import com.aacademy.bike_station.dto.ColorDto;
import com.aacademy.bike_station.dto.SizeDto;
import com.aacademy.bike_station.dto.TypeDto;
import com.aacademy.bike_station.exception.RecordNotFoundException;
import com.aacademy.bike_station.model.Bike;
import com.aacademy.bike_station.model.Color;
import com.aacademy.bike_station.model.Size;
import com.aacademy.bike_station.model.Type;
import com.aacademy.bike_station.repository.BikeRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class BikeService {

    private final BikeRepository bikeRepository;
    private final ColorService colorService;
    private final TypeService typeService;
    private final SizeService sizeService;

    public BikeService(BikeRepository bikeRepository, ColorService colorService, TypeService typeService, SizeService sizeService) {
        this.bikeRepository = bikeRepository;
        this.colorService = colorService;
        this.typeService = typeService;
        this.sizeService = sizeService;
    }

    public BikeDto findById(@NonNull Long id) {
        Bike bike = bikeRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Bike with %s does not exist", id)));

        return BikeDto.builder()
                .color(bike.getColor().getColor())
                .description(bike.getDescription())
                .frameSize(bike.getSize().getFrameSize())
                .wheelSize(bike.getSize().getWheelSize())
                .type(bike.getType().getType())
                .price(bike.getPrice().toString())
                .year(bike.getYear())
                .build();
    }

    public void save(@NonNull BikeDto bikeDto) {
        ColorDto colorDto = colorService.findByColor(bikeDto.getColor());
        TypeDto typeDto = typeService.findByType(bikeDto.getType());
        SizeDto sizeDto = sizeService.findBySize(bikeDto.getWheelSize());

        Color color = Color.builder()
                .id(colorDto.getId())
                .color(colorDto.getColor())
                .build();

        Size size = Size.builder()
                .wheelSize(sizeDto.getWheelSize())
                .frameSize(sizeDto.getFrameSize())
                .build();

        Type type = Type.builder()
                .type(typeDto.getType())
                .build();

        Bike bike = Bike.builder()
                .price(bikeDto.getPrice())
                .year(bikeDto.getYear())
                .description(bikeDto.getDescription())
                .color(color)
                .size(size)
                .type(type)
                .build();

        bikeRepository.save(bike);
    }
}
