package com.sonny.demo.DesignPatterns.P5_DecoratorPattern;

public class EspressoCoffee extends Beverage {

	public EspressoCoffee() {
		description = "Espresso";
	}
	
	@Override
	public double cost() {
		return 1.99;
	}

}
