package registers;

import java.util.ArrayList;

import beans.Semester;

public class SemesterRegister {
	
	private static SemesterRegister semesterRegister=new SemesterRegister();
	private ArrayList<Semester> semesters;

	public ArrayList<Semester> getAllSemesters() {
		return semesters;
	}

	private SemesterRegister(){
		semesters=new ArrayList<Semester>();
	}
	
	public static SemesterRegister getInstance(){
		return semesterRegister;
	}
	
	public void addSemester(String name, String startDate, String endDate){
		Semester semester=new Semester(name, startDate, endDate);
		semesters.add(semester);
	}
	
	public Semester getSemester(String name){
		for(Semester semester:semesters){
			if(semester.getName().equals(name)){
				return semester;
			}
		}
		return null;
	}

}
