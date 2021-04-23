package com.sonny.demo.ExceptionDemo;

/*
 * 1. c:\>javac HandleMultiExceptionDemo.java
 * 2. c:\>java HandleMultiExceptionDemo
 * 3. c:\>java HandleMultiExceptionDemo 100
 * */
public class HandleMultiExceptionDemo {

	public static void main(String[] args) {

		try {

			int i;
			String str = args[0];	//超出Array範圍
			
			for (i = 2; i > -1; i--) {
				System.out.println("計算結果:" + 6 / i);
			}

		} catch (ArithmeticException e) {
			System.out.println("例外說明:" + e.getMessage());
			System.out.print("例外原因:");
			e.printStackTrace();
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("例外說明:" + e.getMessage());
			System.out.print("例外原因:");
			e.printStackTrace();
			
		} finally {
			System.out.println("錯誤處理結束");
		}
		
		System.out.println("程式結束!!");
		
	}

}
