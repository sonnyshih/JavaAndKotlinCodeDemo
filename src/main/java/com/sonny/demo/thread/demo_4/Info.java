package com.sonny.demo.thread.demo_4;

public class Info {
	private String name = "Mr. Lin";
	private String content = "Java Teacher";

	private boolean isProduced = false;
	
	public synchronized void set(String name, String conetnt) {
		
//		System.out.println(" ##### Setting Start ##### ");

		if (!isProduced) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		setName(name);

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		setContent(conetnt);
		isProduced = false;
		notify();
		
//		System.out.println(" ##### Name: "+ name + "; Content: "+ conetnt+" ##### ");
//		System.out.println(" ##### Setting End ##### ");
		
	}

	public synchronized void get() {
		if (isProduced) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(getName() + " --> " + getContent());
		
		isProduced = true;
		notify();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
