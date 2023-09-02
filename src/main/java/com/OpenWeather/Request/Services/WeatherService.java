package com.OpenWeather.Request.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.OpenWeather.Request.Configuration.WeatherResponse;
import com.OpenWeather.Request.Model.WeatherData;
import com.OpenWeather.Request.Model.Wind;

@Service
public class WeatherService {
    private static final String API_KEY = "f4dcd7ec42388beb2d60412d124c7e60";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather";

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherData getWeatherDataForCity(int cityId) {
        String url = API_URL + "?id=" + cityId + "&units=metric&appid=" + API_KEY;
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
        return response.getMain();
    }

    public Wind getWindDataForCity(int cityId) {
        String url = API_URL + "?id=" + cityId + "&units=metric&appid=" + API_KEY;
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
        return response.getWind();
    }
}