package com.sonny.demo.Generics;

public class Demo1_BasicGenerics {

	public static void main(String[] args) {

		// Define the type is integer
		Point<Integer> integerPoint = new Point<Integer>();
		integerPoint.setVar(30);
		System.out.println("Integer Output: " + integerPoint.getVar() * 2);

		// Define the type is String
		Point<String> stringPoint = new Point<String>();
		stringPoint.setVar("I'm a string");
		System.out.println("String Output: " + stringPoint.getVar());

	}

}

class Point<T> {

	private T var;

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}
}
