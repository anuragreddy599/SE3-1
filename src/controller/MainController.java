package controller;

import java.util.ArrayList;

import beans.Course;
import beans.Student;
import registers.CourseRegister;
import registers.StudentRegister;
import schedule.student;
import utils.FileParser;

public class MainController {
	
	private static MainController mainController=new MainController();
	
	private MainController(){
		//FileParser.getInstance().ParseAll();
	}

	public static MainController getInstance(){
		return mainController;
	}
	
	public ArrayList<Course> getCourses(){
		CourseRegister courseRegsiter = CourseRegister.getInstance();
		return courseRegsiter.getAllCourses();
	}
	
	public ArrayList<Student> getStudents(){
		StudentRegister studentRegister = StudentRegister.getInstance();
		return studentRegister.getStudents();
	}
}
