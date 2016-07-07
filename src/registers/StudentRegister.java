package registers;

import java.util.ArrayList;

import beans.Student;

public class StudentRegister {
	
	private static StudentRegister studentRegister=new StudentRegister();
	public static ArrayList<Student> students;

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
        public boolean updateStudent(String studentId, String courseCode,
			String courseName, String semester, String grade){
		for(Student student:students){
                                        if(student.getId().equalsIgnoreCase(studentId)){
                                                String[] num = student.getCourseNum();
                                                String[] name = student.getCourseName();
                                                String[] crsSem = student.getCourseSemester();
                                                String[] crsgrade = student.getGrade();

                                                if(num == null){
                                                        num = new String[1]; 
                                                        name = new String[1];
                                                        crsSem = new String[1];
                                                        crsgrade = new String[1];

                                                        num[0] = courseCode;
                                                        name[0] = courseName;
                                                        crsSem[0] = semester;
                                                        crsgrade[0] = grade;

                                                        student.setCourseNum(num);
                                                        student.setCourseName(name);
                                                        student.setCourseSemester(crsSem);
                                                        student.setGrade(crsgrade);
                                                }else{
                                                        String[] num1 = new String[num.length+1];
                                                        String[] name1 = new String[name.length + 1];
                                                        String[] crsSem1 = new String[crsSem.length + 1];
                                                        String[] crsgrade1 = new String[crsgrade.length + 1];

                                                        for(int k=0;k<num.length;k++){
                                                                num1[k]=num[k];
                                                                name1[k]=name[k];
                                                                crsSem1[k]=crsSem[k];
                                                                crsgrade1[k]=crsgrade[k];
                                                        }
                                                        num1[num.length]=courseCode;
                                                        name1[num.length]=courseName;
                                                        crsSem1[num.length]=semester;
                                                        crsgrade1[num.length]=grade;

                                                        student.setCourseNum(num1);
                                                        student.setCourseName(name1);
                                                        student.setCourseSemester(crsSem1);
                                                        student.setGrade(crsgrade1);

                                                }
			                		
			                		
			                	}
			                }
		return false;
	}
}
