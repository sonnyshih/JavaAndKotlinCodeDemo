package com.sonny.demo.thread.demo_4;

public class Producer implements Runnable{

	private Info info = null;
	
	public Producer (Info info){
		this.info = info;
	}

	@Override
	public void run() {
		boolean flag = false;
		
		for (int i = 0; i < 50; i++) {
			
			if (flag) {
				
				info.set("Mr. Lin", "Java Teacher");
				flag = false;
				
			} else {

				info.set("mldn", "www.mldnjava.cn");
				flag = true;
			}
		}
	}
}
