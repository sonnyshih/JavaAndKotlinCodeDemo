package com.sonny.demo.thread;

public class Demo2_ExtendsThread {

	public static void main(String[] args) {
		System.out.println("Thread: " + Thread.currentThread());
		
		MyThread myThreadA = new MyThread(10, "Thread A");
		myThreadA.start();
		
		MyThread myThreadB = new MyThread(20, "Thread B");
		myThreadB.start();
	}

}

class MyThread extends Thread {
	private int length;
	
	public MyThread(int length, String name) {
		super(name);
		this.length = length;
	}
	
	@Override
	public void run() {
		int sum = 0;
		for (int i = 0; i <= length; i++) {
			sum += i;
		}
		
		System.out.println(Thread.currentThread() + " summary is " + sum);
	}
	
}
