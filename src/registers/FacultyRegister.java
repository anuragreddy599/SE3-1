package registers;

import java.util.ArrayList;

import beans.Faculty;

public class FacultyRegister {
	
	private static FacultyRegister facultyRegister=new FacultyRegister();
	public static ArrayList<Faculty> faculties;

	public ArrayList<Faculty> getAllFaculties() {
		return faculties;
	}

	private FacultyRegister(){
		faculties=new ArrayList<Faculty>();
	}
	
	public static FacultyRegister getInstance(){
		return facultyRegister;
	}
	
	public void addFaculty(String lname, String fname, String school, String degree,
			String title, String days, String maxLoadFA, String maxLoadSP,
			String maxLoadSU){
		Faculty faculty=new Faculty(lname, fname, school, degree, title, days, maxLoadFA, maxLoadSP, maxLoadSU);
		faculties.add(faculty);
	}
	
	public boolean editFaculty(String lname, String fname, String school, String degree,
			String title, String days, String maxLoadFA, String maxLoadSP,
			String maxLoadSU){
		for(int i=0;i<faculties.size();i++){
			Faculty faculty=faculties.get(i);
			if(faculty.getLname().equals(lname)){
				faculty.setLname(lname);
				faculty.setFname(fname);
				faculty.setSchool(school);
				faculty.setDegree(degree);
				faculty.setTitle(title);
				faculty.setDays(days);
				faculty.setMaxLoadFA(maxLoadFA);
				faculty.setMaxLoadSP(maxLoadSP);
				faculty.setMaxLoadSU(maxLoadSU);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteFaculty(String lname){
		for(int i=0;i<faculties.size();i++){
			Faculty faculty=faculties.get(i);
			if(faculty.getLname().equals(lname)){
				faculties.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Faculty getFaculty(String lname){
		for(Faculty faculty:faculties){
			if(faculty.getLname().equals(lname)){
				return faculty;
			}
		}
		return null;
	}

}
