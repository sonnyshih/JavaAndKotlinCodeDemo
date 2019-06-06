package com.sonny.demo.thread.demo_4;

public class Demo4 {

	public static void main(String[] args) {
		Info info = new Info();
		Producer producer = new Producer(info);
		Consumer consumer = new Consumer(info);
		
		new Thread(producer).start();
		new Thread(consumer).start();
		
	}

}



