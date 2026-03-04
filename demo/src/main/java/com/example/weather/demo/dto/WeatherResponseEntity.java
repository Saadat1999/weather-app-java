package com.example.weather.demo.dto;

import com.example.weather.demo.entity.Weather;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponseEntity {
    @JsonProperty("weather")
    private Weather[] weathers;
}
