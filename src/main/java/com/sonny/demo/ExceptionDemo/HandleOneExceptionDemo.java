package com.sonny.demo.ExceptionDemo;

public class HandleOneExceptionDemo {

	public static void main(String[] args) {

		try {

			int i;

			for (i = 2; i > -1; i--) {
				System.out.println("�p�⵲�G:" + 6 / i);
			}

		} catch (ArithmeticException e) {
			System.out.println("�ҥ~����:" + e.getMessage());
			System.out.print("�ҥ~��]:");
			e.printStackTrace();
			
		} finally {
			System.out.println("���~�B�z����");
		}
		
		System.out.println("�{������!!");
	}

}
