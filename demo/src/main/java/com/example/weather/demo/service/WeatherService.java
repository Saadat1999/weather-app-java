package com.example.weather.demo.service;

import com.example.weather.demo.dto.CityCoordinates;
import com.example.weather.demo.dto.CityWeather;
import com.example.weather.demo.mapper.GeoLocationMapper;
import com.example.weather.demo.mapper.WeatherInfoMapper;
import com.example.weather.demo.provider.GeoCodingProvider;
import com.example.weather.demo.provider.WeatherProvider;
import com.example.weather.demo.dto.WeatherRequestDetails;
import com.example.weather.demo.dto.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private final GeoCodingProvider geoCodingProvider;
    private final WeatherProvider weatherProvider;

    @Autowired
    public WeatherService( GeoCodingProvider geoCodingProvider, WeatherProvider weatherProvider) {
        this.geoCodingProvider = geoCodingProvider;
        this.weatherProvider = weatherProvider;
    }

    public WeatherResponse getWeather(WeatherRequestDetails weatherRequest) {
        CityCoordinates cityCoordinates = GeoLocationMapper.mapFrom(geoCodingProvider.getCoordinates(weatherRequest));

        CityWeather cityWeather = WeatherInfoMapper.mapFrom(weatherProvider.getWeatherInfo(cityCoordinates));

        return WeatherInfoMapper.mapFrom(cityWeather);
    }
}
