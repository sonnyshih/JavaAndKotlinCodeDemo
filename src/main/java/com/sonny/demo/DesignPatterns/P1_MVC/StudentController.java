package com.sonny.demo.DesignPatterns.P1_MVC;

public class StudentController {

	private StudentModel studentModel;
	
	public StudentController(StudentModel studentModel){
		this.studentModel = studentModel;
		
	}
	
	public void initStudentData(String name, String rollNo){
		studentModel.initStudentModel(name, rollNo);
	}
	
	public void changeRollNo(String rollNo){
		studentModel.setRollNo(rollNo);
	}
	
	public void changeName(String name){
		studentModel.setName(name);
	}
	
}
