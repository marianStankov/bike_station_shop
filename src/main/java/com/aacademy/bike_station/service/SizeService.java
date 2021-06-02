package com.aacademy.bike_station.service;

import com.aacademy.bike_station.dto.SizeDto;
import com.aacademy.bike_station.exception.RecordNotFoundException;
import com.aacademy.bike_station.model.Size;
import com.aacademy.bike_station.repository.SizeRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class SizeService {

    private final SizeRepository sizeRepository;

    public SizeService(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    public SizeDto findBySize(@NonNull Integer wheelSize) {
        Size size = sizeRepository.findBySize(wheelSize)
                .orElseThrow(() ->
                        new RecordNotFoundException(String.format("Wheel size %d not found.", wheelSize)));

        return SizeDto.builder()
                .frameSize(size.getFrameSize())
                .wheelSize(size.getWheelSize())
                .build();
    }
}
