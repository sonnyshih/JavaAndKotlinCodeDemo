package com.sonny.demo.DesignPatterns.P5_DecoratorPattern;

public abstract class Beverage {
	
	protected String description = "Unknown Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}
