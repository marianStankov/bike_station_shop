package com.aacademy.bike_station.service;

import com.aacademy.bike_station.dto.TypeDto;
import com.aacademy.bike_station.exception.RecordNotFoundException;
import com.aacademy.bike_station.model.Type;
import com.aacademy.bike_station.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

    public final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public TypeDto findByType(String type) {
        Type bikeType = typeRepository.findByType(type)
                .orElseThrow(() -> new RecordNotFoundException(String.format("%s not found.", type)));

        return TypeDto.builder()
                .id(bikeType.getId())
                .type(bikeType.getType())
                .build();
    }
}
