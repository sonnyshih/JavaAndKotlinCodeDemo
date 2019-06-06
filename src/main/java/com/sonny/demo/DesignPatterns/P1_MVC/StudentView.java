package com.sonny.demo.DesignPatterns.P1_MVC;

public class StudentView {
	
	public void showRollNoView(String rollNo){
		System.out.println("Roll No: " + rollNo);
	}
	
	public void showNameView(String name){
		System.out.println("Name: " + name);
	}
	
	public void printStudentDetails(String studentName, String studentRollNo) {
		System.out.println("Student: ");
		System.out.println("Name: " + studentName);
		System.out.println("Roll No: " + studentRollNo);
	}
}
