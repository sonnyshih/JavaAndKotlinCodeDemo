package com.sonny.demo.Generics;

public class Demo2_MultiGenerics {

	public static void main(String[] args) {
		Notepad<String, Integer> notepad = new Notepad<String, Integer>();

		notepad.setKey("Hello");
		notepad.setValue(25);

		System.out.println("Name: " + notepad.getKey());
		System.out.println("Age: " + notepad.getValue());
	}

}

class Notepad<K, V> {
	private K key;
	private V value;

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
