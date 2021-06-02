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
@Table(name = "features")
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String price;

    @Column(unique = true, nullable = false)
    private Integer year;

    @Lob
    private String description;

    @OneToMany
    @JoinColumn(name = "bike_color_id")
    private Color color;

    @OneToMany
    @JoinColumn(name = "bike_size_id")
    private Size size;

    @OneToMany
    @JoinColumn(name = "bike_type_id")
    private Type type;
}

