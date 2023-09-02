package com.OpenWeather.Request.Configuration;

import com.OpenWeather.Request.Model.WeatherData;
import com.OpenWeather.Request.Model.Wind;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {
    @JsonProperty("main")
    private WeatherData main;

    @JsonProperty("wind")
    private Wind wind;

	/**
	 * 
	 */
	public WeatherResponse() {
	
	}

	/**
	 * @param main
	 * @param wind
	 */
	public WeatherResponse(WeatherData main, Wind wind) {
		super();
		this.main = main;
		this.wind = wind;
	}

	public WeatherData getMain() {
		return main;
	}

	public void setMain(WeatherData main) {
		this.main = main;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}
	


}
