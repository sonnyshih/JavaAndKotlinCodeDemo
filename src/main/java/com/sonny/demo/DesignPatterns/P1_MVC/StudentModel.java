package com.sonny.demo.DesignPatterns.P1_MVC;

public class StudentModel {

	private StudentView studentView;
	
	private String name;
	private String rollNo;

	public StudentModel(StudentView studentView){
		this.studentView = studentView;
	}
	
	public void initStudentModel(String name, String rollNo){
		this.name = name;
		this.rollNo = rollNo;
		studentView.printStudentDetails(name, rollNo);
	}
	
	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
		studentView.printStudentDetails(name, rollNo);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		studentView.printStudentDetails(name, rollNo);
	}

}
