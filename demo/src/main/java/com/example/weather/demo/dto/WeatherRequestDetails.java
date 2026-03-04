package com.example.weather.demo.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WeatherRequestDetails {
    private String city;
}
