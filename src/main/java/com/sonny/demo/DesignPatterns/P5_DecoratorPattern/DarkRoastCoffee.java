package com.sonny.demo.DesignPatterns.P5_DecoratorPattern;

public class DarkRoastCoffee extends Beverage {

	public DarkRoastCoffee() {
		description = "Dark Roast";
	}
	
	@Override
	public double cost() {
		return 1.99;
	}

}
