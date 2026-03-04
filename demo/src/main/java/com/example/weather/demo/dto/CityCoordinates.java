package com.example.weather.demo.dto;

import lombok.*;

@Builder
@Setter
@Getter
public class CityCoordinates {
    private double latitude;
    private double longitude;
}
