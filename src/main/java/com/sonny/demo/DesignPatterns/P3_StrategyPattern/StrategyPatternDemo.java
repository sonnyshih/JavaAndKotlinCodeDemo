/*
 * Design Pattern: ????  (Strategy Pattern)
 * 
 */
package com.sonny.demo.DesignPatterns.P3_StrategyPattern;

public class StrategyPatternDemo {

	public static void main(String[] args) {
		
		// Mallar Duck
		Duck mallard = new MallarDuck();
		mallard.display();
		mallard.performFly();
		mallard.performQuack();

		System.out.println("\n/* ############################### */\n");
		
		// Model Duck
		Duck modelDuck = new ModelDuck();
		modelDuck.display();
		modelDuck.performFly();
		modelDuck.setFlyBehavior(new FlyRocketPowered());
		modelDuck.performFly();
		modelDuck.performQuack();
	}

}
