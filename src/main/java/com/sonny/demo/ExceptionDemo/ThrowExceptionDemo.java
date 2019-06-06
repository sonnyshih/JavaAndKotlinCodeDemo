package com.sonny.demo.ExceptionDemo;

/*
 * 1. c:\>javac ThrowExceptionDemo.java
 * 2. c:\>java ThrowExceptionDemo 10 20 0 (出現 "c 不能是 0 !" 例外說明)
 * 3. c:\>java ThrowExceptionDemo -10 20 4 (出現 "運算結果小於0!" 例外說明)
 * 4. c:\>java ThrowExceptionDemo 10 20 5 (正確輸出)
 * */
public class ThrowExceptionDemo {

	static double cal(double a, double b, double c) {
		double value;
		
		if (c == 0) {
			throw new IllegalArgumentException("c 不能是 0 !");
			
		} else {
			value = a * b / c;
			
			if (value < 0) {
				throw new IllegalArgumentException("運算結果小於0!");
			}
		}

		return value;

	}

	public static void main(String[] args) {
		double result;
		
		try {
			double a = Double.parseDouble(args[0]);
			double b = Double.parseDouble(args[1]);
			double c = Double.parseDouble(args[2]);
			
			result = cal(a, b, c);
			System.out.println("計算結果:" + result);
			
		} catch (IllegalArgumentException e) {
			
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
