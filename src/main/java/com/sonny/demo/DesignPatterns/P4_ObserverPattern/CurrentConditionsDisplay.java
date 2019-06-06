package com.sonny.demo.DesignPatterns.P4_ObserverPattern;

public class CurrentConditionsDisplay implements Observer, DisplayElement{

	private Subject weatherData;
	private float temperature;
	private float humidity;
	
	public CurrentConditionsDisplay(Subject weatherData){
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		display();
	}

	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature+ "F degrees and " +
				humidity + "% humidity");
		
	}

}
