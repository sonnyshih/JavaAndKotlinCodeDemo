package com.sonny.demo.DesignPatterns.P3_StrategyPattern;

public class FlyWithWings implements FlyBehavior{

	@Override
	public void fly() {
		System.out.println("I'm flying!!");
	}

}
