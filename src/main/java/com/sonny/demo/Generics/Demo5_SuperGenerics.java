package com.sonny.demo.Generics;

public class Demo5_SuperGenerics {

	public static void main(String[] args) {
		InfoSuper<Object> info1 = new InfoSuper<Object>();
		info1.setVar(new Object());
		fun(info1);

		InfoSuper<String> info2 = new InfoSuper<String>();
		info2.setVar("Hello world!!");
		fun(info2);
	}

	public static void fun(InfoSuper<? super String> info){
		System.out.println("fun Content: " + info);
	}
}

// Can not define class InfoSuper<T super String>
class InfoSuper<T> {
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

