package com.sonny.demo.serialization;

import java.io.Serializable;

public class MyClass implements Serializable{
	private static final long serialVersionUID = -1175849846430692431L;
	
	private String s;
	private int i;
	private double d;

	public MyClass(String s, int i, double d) {
		this.s = s;
		this.i = i;
		this.d = d;
	}

	@Override
	public String toString() {
		return "s=" + s + ";   i=" + i + ";   d=" + d;
	}
	
}
