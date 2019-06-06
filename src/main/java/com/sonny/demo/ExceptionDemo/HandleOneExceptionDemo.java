package com.sonny.demo.ExceptionDemo;

public class HandleOneExceptionDemo {

	public static void main(String[] args) {

		try {

			int i;

			for (i = 2; i > -1; i--) {
				System.out.println("計算結果:" + 6 / i);
			}

		} catch (ArithmeticException e) {
			System.out.println("例外說明:" + e.getMessage());
			System.out.print("例外原因:");
			e.printStackTrace();
			
		} finally {
			System.out.println("錯誤處理結束");
		}
		
		System.out.println("程式結束!!");
	}

}
