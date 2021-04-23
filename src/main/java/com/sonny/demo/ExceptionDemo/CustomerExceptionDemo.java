package com.sonny.demo.ExceptionDemo;

class MyException extends Exception {
	int data;

	public MyException(int data) {
		this.data = data;
	}

	@Override
	public String getMessage() {
		return ("出價太多次:" + data);
	}

}

public class CustomerExceptionDemo {

	public static void main(String[] args) {

		try {

			int i;
			for (i = 0; i < 5; i++) {
				if (i == 3) {
					throw new MyException(i);
				}

				System.out.println("出價次數:" + i);
			}

		} catch (MyException e) {

			System.out.println("例外說明:" + e.getMessage());
			System.out.print("例外原因:");
			e.printStackTrace();

		} finally {
			System.out.println("錯誤處理結束");
		}

		System.out.println("程式結束!!");

	}

}
