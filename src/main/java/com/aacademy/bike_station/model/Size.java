package com.aacademy.bike_station.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sizes")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String frameSize;

    @Column(unique = true, precision = 3, scale = 1, nullable = false)
    private Integer wheelSize;

    @ManyToOne
    @JoinColumn(name = "bike_id")
    private Bike bike;
}

