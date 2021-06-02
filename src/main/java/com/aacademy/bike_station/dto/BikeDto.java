package com.aacademy.bike_station.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BikeDto {

    private String price;
    private Integer year;
    private String description;
    private String color;
    private String frameSize;
    private Integer wheelSize;
    private String type;
}
