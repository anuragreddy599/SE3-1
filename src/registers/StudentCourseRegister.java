package registers;

import java.util.ArrayList;

import beans.StudentCourse;

public class StudentCourseRegister {
	
	private static StudentCourseRegister studentCourseRegister=new StudentCourseRegister();
	public static ArrayList<StudentCourse> studentCourses;

	private StudentCourseRegister(){
		studentCourses=new ArrayList<StudentCourse>();
	}
	
	public static StudentCourseRegister getInstance(){
		return studentCourseRegister;
	}
	
	public void addStudentCourse(String studentId, String courseCode,
			String courseName, String semester, String grade){
		StudentCourse studentCourse=new StudentCourse(studentId, courseCode, courseName, semester, grade);
                StudentRegister.getInstance().updateStudent(studentId, courseCode, courseName, semester, grade);
		studentCourses.add(studentCourse);
	}
	
	public ArrayList<StudentCourse> getStudentCourses(String id){
		ArrayList<StudentCourse> courses=new ArrayList<StudentCourse>();
		for(StudentCourse studentCourse:studentCourses){
			if(studentCourse.getStudentId().equals(id)){
				courses.add(studentCourse);
			}
		}
		return courses;
	}

}
