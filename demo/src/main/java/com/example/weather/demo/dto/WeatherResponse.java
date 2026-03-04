package com.example.weather.demo.dto;

import lombok.*;

@Builder
@Setter
@Getter
public class WeatherResponse {
    private String weather;
    private String details;
}
