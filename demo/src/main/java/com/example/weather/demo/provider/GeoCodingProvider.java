package com.example.weather.demo.provider;

import com.example.weather.demo.dto.WeatherRequestDetails;
import com.example.weather.demo.entity.GeoCoding;
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
public class GeoCodingProvider {
    @Value("${api.key}")
    private String apiKey;
    @Value("${geocoding.url}")
    private String geoCodingUrl;

    public GeoCoding getCoordinates(WeatherRequestDetails weatherRequestDetails) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<GeoCoding[]> responseEntity;

        HttpEntity<String> request = new HttpEntity<>(null, (HttpHeaders) null);

        UriBuilder uriBuilder = UriComponentsBuilder.fromUriString(geoCodingUrl).
                queryParam("q", weatherRequestDetails.getCity()).
                queryParam("limit", "1").
                queryParam("appid", apiKey);

        try{
            responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
                    HttpMethod.GET,
                    request,
                    GeoCoding[].class);
        } catch (HttpStatusCodeException e) {
            throw new RuntimeException("Data fetching failed");
        }


        if(responseEntity.getBody()==null) {
            throw new RuntimeException("City not found");
        }
        return responseEntity.getBody()[0];
    }
}
