package registers;

import beans.DegreeReqs;
import java.util.ArrayList;

import beans.Semester;
import static registers.DegreeReqsRegister.degreeReqs;

public class SemesterRegister {
	
	private static SemesterRegister semesterRegister=new SemesterRegister();
	public static ArrayList<Semester> semesters;

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
	public boolean editSemester(String name, String startDate, String endDate){		
		
		for(int i=0;i<semesters.size();i++){
			Semester semister=semesters.get(i);			
			if(semister.getName().equals(name)){
				semister.setName(name);
				semister.setStartDate(startDate);
				semister.setEndDate(endDate);
				
				return true;
			}
		}
		return false;
	}
	public Semester getSemester(String name){
		for(Semester semester:semesters){
			if(semester.getName().equals(name)){
				return semester;
			}
		}
		return null;
	}

        public boolean deleteSemester(String name){
		for(int i=0;i<semesters.size();i++){
			Semester sem=semesters.get(i);
			if(sem.getName().equals(name)){
				semesters.remove(i);
				return true;
			}
		}
		return false;
	}
}
