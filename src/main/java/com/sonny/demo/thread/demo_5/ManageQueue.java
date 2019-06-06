package com.sonny.demo.thread.demo_5;

public class ManageQueue {
	private Queue queue = new Queue();

	public ManageQueue() {

	}

	public synchronized void enqueue(Person person) {

		try {

			while (queue.isFull()) {

				System.out.println("The Queue is full, Please waiting...");
				wait();
			}

			queue.pushQueue(person);
			notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized Person dequeue() {
		Person person = null;

		try {
			
			while (queue.isEmpty()) {

				System.out.println("The Queue is empty, Please waiting...");
				wait();
			}
			
			person = queue.outputQueue();
			notify();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return person;
	}

}
