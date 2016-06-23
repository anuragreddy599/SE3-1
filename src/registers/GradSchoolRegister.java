package registers;

import beans.GradSchool;

public class GradSchoolRegister{

	private static GradSchoolRegister gradSchoolRegister=new GradSchoolRegister();
	private GradSchool gradSchool;

	private GradSchoolRegister(){}

	public static GradSchoolRegister getInstance(){
		return gradSchoolRegister;
	}

	public void addGradSchool(String name,String abrevation){
		gradSchool=new GradSchool(name,abrevation);
	}

	public GradSchool getGradSchool(){
		return gradSchool;
	}

}
