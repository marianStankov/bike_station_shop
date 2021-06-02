package com.aacademy.bike_station.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SizeDto {

    private String frameSize;
    private Integer wheelSize;
}
