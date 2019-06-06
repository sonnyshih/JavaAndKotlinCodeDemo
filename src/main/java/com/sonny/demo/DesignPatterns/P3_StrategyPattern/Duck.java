package com.sonny.demo.DesignPatterns.P3_StrategyPattern;

public abstract class Duck {
	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;
	
	public Duck(){
		
	}
	
	abstract void display();
	
	public void performFly(){
		flyBehavior.fly();
	}
	
	public void performQuack(){
		quackBehavior.quack();
	}
	
	public void swim(){
		System.out.println("All ducks float, even decoys!");
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
	
	
}
