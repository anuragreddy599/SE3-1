package registers;

import beans.University;

public class UniversityRegister{

	private static UniversityRegister uniRegister=new UniversityRegister();
	private University uni;

	private UniversityRegister(){}

	public static UniversityRegister getInstance(){
		return uniRegister;
	}

	public void addUniversity(String name,String abrevation){
		uni=new University(name,abrevation);
	}

	public University getUniversity(){
		return uni;
	}

}
