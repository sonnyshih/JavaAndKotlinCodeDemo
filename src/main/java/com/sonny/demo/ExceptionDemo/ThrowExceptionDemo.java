package com.sonny.demo.ExceptionDemo;

/*
 * 1. c:\>javac ThrowExceptionDemo.java
 * 2. c:\>java ThrowExceptionDemo 10 20 0 (�X�{ "c ����O 0 !" �ҥ~����)
 * 3. c:\>java ThrowExceptionDemo -10 20 4 (�X�{ "�B�⵲�G�p��0!" �ҥ~����)
 * 4. c:\>java ThrowExceptionDemo 10 20 5 (���T��X)
 * */
public class ThrowExceptionDemo {

	static double cal(double a, double b, double c) {
		double value;
		
		if (c == 0) {
			throw new IllegalArgumentException("c ����O 0 !");
			
		} else {
			value = a * b / c;
			
			if (value < 0) {
				throw new IllegalArgumentException("�B�⵲�G�p��0!");
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
			System.out.println("�p�⵲�G:" + result);
			
		} catch (IllegalArgumentException e) {
			
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
