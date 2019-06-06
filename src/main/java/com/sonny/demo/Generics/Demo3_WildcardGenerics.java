package com.sonny.demo.Generics;

public class Demo3_WildcardGenerics {

	public static void main(String[] args) {
		// Define the type is Object
		Info<Object> info = new Info<Object>();
		info.setVar("Hello World");
		System.out.println("Content: " + info.getVar());
		
		fun(info);
	}
	
	public static void fun(Info<?> info){
		System.out.println("fun Content: " + info);
	}

}

class Info<T> {
	private T var;

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}

	public String toString() {
		return this.var.toString();
	}
}
