package registers;

import java.util.ArrayList;

import beans.Course;

public class CourseRegister {

	private static CourseRegister courseRegister=new CourseRegister();
	public static ArrayList<Course> courses;

	private CourseRegister(){
		courses=new ArrayList<Course>();
	}

	public static CourseRegister getInstance(){
		return courseRegister;
	}

	public void addCourse(String code, String name, String desc, String hour,
			String cap, String offeredFA, String offeredSP, String offeredSU,
			String preReqs, String teachers){
		Course course=new Course(code, name, desc, hour, cap, offeredFA, offeredSP,
				offeredSU, preReqs, teachers);
		courses.add(course);
	}

	public boolean editCourse(String code, String name, String desc, String hour,
			String cap, String offeredFA, String offeredSP, String offeredSU,
			String preReqs, String teachers){		
		
		for(int i=0;i<courses.size();i++){
			Course course=courses.get(i);			
			if(course.getCode().equals(code)){
				course.setCode(code);
				course.setName(name);
				course.setDesc(desc);
				course.setHour(hour);
				course.setCap(cap);
				course.setOfferedFA(offeredFA);
				course.setOfferedSP(offeredSP);
				course.setOfferedSU(offeredSU);
				course.setPreReqs(preReqs);
				course.setTeachers(teachers);
				return true;
			}
		}
		return false;
	}

	public boolean deleteCourse(String code){
		for(int i=0;i<courses.size();i++){
			Course course=courses.get(i);
			if(course.getCode().equals(code)){
				courses.remove(i);
				return true;
			}
		}
		return false;
	}

	public Course getCourse(String code){
		for(Course course:courses){
			if(course.getCode().equals(code)){
				return course;
			}
		}
		return null;
	}
	
	public ArrayList<Course> getAllCourses(){
		return this.courses;
	}

}
