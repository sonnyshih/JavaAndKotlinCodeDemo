package com.sonny.demo.DesignPatterns.P1_MVC;
/*
 * MVC or MVP Pattern ¡V Whats the difference?
 * 1. http://www.infragistics.com/community/blogs/todd_snyder/archive/2007/10/17/mvc-or-mvp-pattern-whats-the-difference.aspx
 * 2. http://stackoverflow.com/questions/2056/what-are-mvp-and-mvc-and-what-is-the-difference
 * */
public class MVCDesignPatternDemo {

	public static void main(String[] args) {
		StudentView view = new StudentView();
		StudentModel model = new StudentModel(view);
		
		StudentController controller = new StudentController(model);
		controller.initStudentData("Robert", "10");
	
		System.out.println("<!-- ###### Change Student Data ##### -->");
		System.out.println("###### 1. Change Name #####");
		controller.changeName("John");
		
		System.out.println("###### 2. Change Roll No. #####");
		controller.changeRollNo("20");
		
	}

}
