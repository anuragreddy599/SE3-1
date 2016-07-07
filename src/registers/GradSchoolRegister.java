package registers;

import beans.GradSchool;


public class GradSchoolRegister{

	private static GradSchoolRegister gradSchoolRegister=new GradSchoolRegister();
	public static GradSchool gradSchool;

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
         public boolean editGradSchool(String name,String abrevation){
		gradSchool.setAbbrevation(abrevation);
                gradSchool.setName(name);
		return true;
	}
}
