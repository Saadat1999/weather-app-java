package com.example.weather.demo.mapper;

import com.example.weather.demo.entity.GeoCoding;
import com.example.weather.demo.dto.CityCoordinates;

public class GeoLocationMapper {

    public static CityCoordinates mapFrom(GeoCoding geoCoding) {
        return CityCoordinates.builder().
                latitude(geoCoding.getLatitude()).
                longitude(geoCoding.getLongitude()).
                build();
    }
}
