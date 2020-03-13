package com.sonny.demo.HandleString;

public class SplitStringDemo {

	public static void main(String[] args) {
		String a = "Imagination is more important than knowledge.";
		String b = "He who has hope has everything.";
		String c = "台上一分鐘，台下十年功。";

		String[] aArray = a.split(" ");
		String[] bArray = b.split(" ", 2);
		String[] cArray = c.split("，");

		
		System.out.println("/* ##### aArray Demo ##### */");
		for (String d : aArray) {
			System.out.println(d);
		}

		System.out.println("/* ##### bArray Demo ##### */");
		for (String d : bArray) {
			System.out.println(d);
		}

		System.out.println("/* ##### cArray Demo ##### */");
		for (String d : cArray) {
			System.out.println(d);
		}
	}

}
