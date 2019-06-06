package com.sonny.demo.DesignPatterns.P3_StrategyPattern;

public class MuteQuack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("<< Silence >>");		
	}

}
