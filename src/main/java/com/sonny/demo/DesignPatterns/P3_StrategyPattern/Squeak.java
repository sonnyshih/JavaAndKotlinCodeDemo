package com.sonny.demo.DesignPatterns.P3_StrategyPattern;

public class Squeak implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("Squeak Squeak !!");		
	}

}
