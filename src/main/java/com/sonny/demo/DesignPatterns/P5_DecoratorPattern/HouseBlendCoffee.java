package com.sonny.demo.DesignPatterns.P5_DecoratorPattern;

public class HouseBlendCoffee extends Beverage {

	public HouseBlendCoffee() {
		description = "House Blend Coffee";
	}
	
	@Override
	public double cost() {
		return 0.89;
	}

}
