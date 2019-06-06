package com.sonny.demo.thread.demo_5;

public class Queue {
	private int MAXQUEUE = 5;
	private Person[] personQueue = new Person[MAXQUEUE];
	private int frontPointer = 0;
	private int tailPointer = 0;

	public boolean isEmpty() {
		if (frontPointer == tailPointer) {
			return true;
		}

		return false;
	}

	public boolean isFull() {
		int index = tailPointer + 1;

		if (index >= MAXQUEUE) {
			index = 0;
		}

		if (index == frontPointer) {
			return true;
		}

		return false;
	}

	public void pushQueue(Person person) {
		frontPointer++;
		if (frontPointer >= MAXQUEUE) {
			frontPointer = 0;
		}

		personQueue[frontPointer] = person;
	}

	public Person outputQueue() {
		tailPointer++;
		if (tailPointer >= MAXQUEUE) {
			tailPointer = 0;
		}

		return personQueue[tailPointer];
	}
}
