package registers;

import beans.Faculty;
import beans.GradSchool;
import beans.University;
import static registers.FacultyRegister.faculties;

public class UniversityRegister{

	private static UniversityRegister uniRegister=new UniversityRegister();
	public static University uni;
        public static GradSchool gradSch;

	private UniversityRegister(){}

	public static UniversityRegister getInstance(){
		return uniRegister;
	}

	public void addUniversity(String name,String abrevation){
		uni=new University(name,abrevation);
	}
        public boolean editUniversity(String name,String abrevation){
		uni.setAbbrevation(abrevation);
                uni.setName(name);
		return true;
	}
	public University getUniversity(){
		return uni;
	}
        public GradSchool getGradSchool(){
		return gradSch;
	}
        public void addGradSchool(String name,String abrevation){
		gradSch=new GradSchool(name,abrevation);
	}
        public boolean editGradSchool(String name,String abrevation){
		gradSch.setAbbrevation(abrevation);
                gradSch.setName(name);
		return true;
	}
}
