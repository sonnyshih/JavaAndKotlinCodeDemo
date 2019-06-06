package com.sonny.demo.enumdemo;

public class Demo1 {

	public static void main(String[] args) {
		Color color = Color.BLUE;
		System.out.println("color: " + color);
		
		printEnumValue();
	}
	
	public static void printEnumValue(){
		System.out.println("##### print Enum Value #####");
		
		for (Color color : Color.values()) {
			
			System.out.println("Color: " + color);
		}
	}
	
	

}
