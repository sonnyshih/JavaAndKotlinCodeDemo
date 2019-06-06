package com.sonny.demo.Generics;

public class Demo4_ExtendsGenerics {

	public static void main(String[] args) {
		
		InfoExtends<Integer> info = new InfoExtends<Integer>();
		info.setVar(100);
		System.out.println("Content: " + info.getVar());

		fun(info);
	}
	
	// Also can define fun(InfoExtends<? extends Number> info)
	public static void fun(InfoExtends<?> info){
		System.out.println("fun Content: " + info);
	}
}

class InfoExtends<T extends Number> {
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
