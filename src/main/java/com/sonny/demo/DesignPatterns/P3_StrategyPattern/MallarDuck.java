package com.sonny.demo.DesignPatterns.P3_StrategyPattern;

public class MallarDuck extends Duck{

	public MallarDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}
	
	@Override
	void display() {
		System.out.println("I'm a real Mallard duck!");
		
	}

}
