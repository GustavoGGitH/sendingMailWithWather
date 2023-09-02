package com.OpenWeather.Request.Model;

public class WeatherData {
	
	
	private double temp;
	private double temp_min;
	private double temp_max;
	private int humidity;
	/**
	 * 
	 */
	public WeatherData() {
	
	}
	/**
	 * @param temp
	 * @param temp_min
	 * @param temp_max
	 * @param humidity
	 */
	public WeatherData(double temp, double temp_min, double temp_max, int humidity) {
		super();
		this.temp = temp;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.humidity = humidity;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public double getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(double temp_min) {
		this.temp_min = temp_min;
	}
	public double getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(double temp_max) {
		this.temp_max = temp_max;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + humidity;
		long temp;
		temp = Double.doubleToLongBits(this.temp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(temp_max);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(temp_min);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeatherData other = (WeatherData) obj;
		if (humidity != other.humidity)
			return false;
		if (Double.doubleToLongBits(temp) != Double.doubleToLongBits(other.temp))
			return false;
		if (Double.doubleToLongBits(temp_max) != Double.doubleToLongBits(other.temp_max))
			return false;
		if (Double.doubleToLongBits(temp_min) != Double.doubleToLongBits(other.temp_min))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "WeatherData [temp=" + temp + ", temp_min=" + temp_min + ", temp_max=" + temp_max + ", humidity="
				+ humidity + "]";
	}
	


	

}
