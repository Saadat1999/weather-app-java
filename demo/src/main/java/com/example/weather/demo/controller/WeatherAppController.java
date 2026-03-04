package com.example.weather.demo.controller;

import com.example.weather.demo.dto.WeatherRequestDetails;
import com.example.weather.demo.dto.WeatherResponse;
import com.example.weather.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class WeatherAppController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherAppController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/{city}")
    public WeatherResponse weather(@PathVariable String city) {
        WeatherRequestDetails weatherRequestDetails = WeatherRequestDetails.builder().city(city).build();

        return weatherService.getWeather(weatherRequestDetails);
    }
}
