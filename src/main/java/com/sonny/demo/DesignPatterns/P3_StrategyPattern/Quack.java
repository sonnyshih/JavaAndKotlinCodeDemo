package com.sonny.demo.DesignPatterns.P3_StrategyPattern;

public class Quack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("Quack Quack !!");
	}

}
