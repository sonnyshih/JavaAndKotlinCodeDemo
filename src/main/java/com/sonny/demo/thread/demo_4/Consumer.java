package com.sonny.demo.thread.demo_4;

public class Consumer implements Runnable {
	private Info info;

	public Consumer(Info info) {
		this.info = info;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(100);
				info.get();
//				System.out.println(info.getName() + "-->" + info.getContent());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
