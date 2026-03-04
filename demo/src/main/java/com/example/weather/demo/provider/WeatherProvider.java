package com.example.weather.demo.provider;

import com.example.weather.demo.dto.CityCoordinates;
import com.example.weather.demo.dto.WeatherResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherProvider {
    @Value("${api.key}")
    private String apiKey;
    @Value("${weather.url}")
    private String weatherUrl;


    public WeatherResponseEntity getWeatherInfo(CityCoordinates cityCoordinates) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<>(null, (HttpHeaders) null);

        ResponseEntity<WeatherResponseEntity> responseEntity;

        UriBuilder url = UriComponentsBuilder.fromUriString(weatherUrl).
                queryParam("lat", cityCoordinates.getLatitude()).
                queryParam("lon", cityCoordinates.getLongitude()).
                queryParam("appid", apiKey);

        try{
            responseEntity = restTemplate.exchange(
                    url.toUriString(),
                    HttpMethod.GET,
                    request,
                    WeatherResponseEntity.class
            );
        } catch (HttpStatusCodeException e) {
            throw new RuntimeException("Data fetching failed");
        }

        return responseEntity.getBody();
    }
}
