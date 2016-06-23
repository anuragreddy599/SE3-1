package registers;

import java.util.ArrayList;

import beans.Student;

public class StudentRegister {
	
	private static StudentRegister studentRegister=new StudentRegister();
	private ArrayList<Student> students;

	public ArrayList<Student> getStudents() {
		return students;
	}

	private StudentRegister(){
		students=new ArrayList<Student>();
	}
	
	public static StudentRegister getInstance(){
		return studentRegister;
	}
	
	public void addStudent(String id,String degreePlan,String semester){
		Student student=new Student(id,degreePlan,semester);
		students.add(student);
	}
	
	public boolean editStudent(String id,String degreePlan,String semester){
		for(int i=0;i<students.size();i++){
			Student student=students.get(i);
			if(student.getId().equals(id)){
				student.setId(id);
				student.setDegreePlan(degreePlan);
				student.setSemester(semester);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteStudent(String id){
		for(int i=0;i<students.size();i++){
			Student student=students.get(i);
			if(student.getId().equals(id)){
				students.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Student getStudent(String id){
		for(Student student:students){
			if(student.getId().equals(id)){
				return student;
			}
		}
		return null;
	}

}
