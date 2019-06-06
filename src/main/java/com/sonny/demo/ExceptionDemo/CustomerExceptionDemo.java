package com.sonny.demo.ExceptionDemo;

class MyException extends Exception {
	int data;

	public MyException(int data) {
		this.data = data;
	}

	@Override
	public String getMessage() {
		return ("�X���Ӧh��: " + data);
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

				System.out.println("�X������: " + i);
			}

		} catch (MyException e) {

			System.out.println("�ҥ~����:" + e.getMessage());
			System.out.print("�ҥ~��]:");
			e.printStackTrace();

		} finally {
			System.out.println("���~�B�z����");
		}

		System.out.println("�{������!!");

	}

}
