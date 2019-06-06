package com.sonny.demo.thread;

public class Demo1_Runable {

	public static void main(String[] args) {
		System.out.println("Thread: " + Thread.currentThread());

		// Run thread A
		MyRunnable myRunnableA = new MyRunnable(10);
		Thread threadA = new Thread(myRunnableA, "Thread A");
		threadA.start();

		//Run thread B
		MyRunnable myRunnableB = new MyRunnable(20);
		Thread threadB = new Thread(myRunnableB, "Thread B");
		threadB.start();
	}

}

class MyRunnable implements Runnable {

	private int length;

	public MyRunnable(int length) {
		this.length = length;
	}

	private int sum() {
		int sum = 0;

		for (int i = 0; i < length; i++) {
			sum += i;
		}

		return sum;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread() + " summary is " + sum());
	}

}