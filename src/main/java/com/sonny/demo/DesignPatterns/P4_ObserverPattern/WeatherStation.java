package com.sonny.demo.DesignPatterns.P4_ObserverPattern;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		
		weatherData.setMeasurements(80, 65, 30.4f);
		
	}

}
