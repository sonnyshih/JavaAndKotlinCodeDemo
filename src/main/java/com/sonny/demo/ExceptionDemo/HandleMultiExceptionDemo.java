package com.sonny.demo.ExceptionDemo;

/*
 * 1. c:\>javac HandleMultiExceptionDemo.java
 * 2. c:\>java HandleMultiExceptionDemo
 * 3. c:\>java HandleMultiExceptionDemo 100 (��args���)
 * */
public class HandleMultiExceptionDemo {

	public static void main(String[] args) {

		try {

			int i;
			String str = args[0];	//�W�XArray�d��
			
			for (i = 2; i > -1; i--) {
				System.out.println("�p�⵲�G:" + 6 / i);
			}

		} catch (ArithmeticException e) {
			System.out.println("�ҥ~����:" + e.getMessage());
			System.out.print("�ҥ~��]:");
			e.printStackTrace();
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�ҥ~����:" + e.getMessage());
			System.out.print("�ҥ~��]:");
			e.printStackTrace();
			
		} finally {
			System.out.println("���~�B�z����");
		}
		
		System.out.println("�{������!!");
		
	}

}
