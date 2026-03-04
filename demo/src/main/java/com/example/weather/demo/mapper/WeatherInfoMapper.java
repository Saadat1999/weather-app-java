package com.example.weather.demo.mapper;

import com.example.weather.demo.dto.CityWeather;
import com.example.weather.demo.dto.WeatherResponse;
import com.example.weather.demo.dto.WeatherResponseEntity;


public class WeatherInfoMapper {

    public static CityWeather mapFrom(WeatherResponseEntity weatherResponseEntity) {
        return CityWeather.builder().
                weather(weatherResponseEntity.getWeathers()[0].getMain()).
                details(weatherResponseEntity.getWeathers()[0].getDescription()).
                build();
    }

    public static WeatherResponse mapFrom(CityWeather cityWeather) {
        return WeatherResponse.builder().
                weather(cityWeather.getWeather()).
                details(cityWeather.getDetails()).
                build();
    }
}
