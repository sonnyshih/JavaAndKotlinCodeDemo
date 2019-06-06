package com.sonny.demo.DesignPatterns.P2_MVP;

public class MVPDesignPatternDemo {

	public static void main(String[] args) {
		// fetch student record based on his roll no from the database
		StudentModel model = retriveStudentFromDatabase();

		// Create a view : to write student details on console
		StudentView view = new StudentView();

		StudentPresenter presenter = new StudentPresenter(model, view);

		presenter.updateView();

		// update model data
		presenter.setStudentName("John");

		presenter.updateView();
	}

	private static StudentModel retriveStudentFromDatabase() {
		StudentModel studentModel = new StudentModel();
		studentModel.setName("Robert");
		studentModel.setRollNo("10");
		return studentModel;
	}
}
