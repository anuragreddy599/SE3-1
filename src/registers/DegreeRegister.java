package registers;

import java.util.ArrayList;

import beans.Degree;

public class DegreeRegister {
	
	private static DegreeRegister degreeRegister=new DegreeRegister();
	public static ArrayList<Degree> degrees;

	public ArrayList<Degree> getAllDegrees() {
		return degrees;
	}

	private DegreeRegister(){
		degrees=new ArrayList<Degree>();
	}
	
	public static DegreeRegister getInstance(){
		return degreeRegister;
	}
	
	public void addDegree(String code,String gradSchool,String name,String forecast){
		Degree degree=new Degree(code,gradSchool,name,forecast);
		degrees.add(degree);
	}
	
	public boolean editDegree(String code,String gradSchool,String name,String forecast){		
		for(int i=0;i<degrees.size();i++){
			Degree degree=degrees.get(i);
			if(degree.getCode().equals(code)){
				degree.setCode(code);
				degree.setGradSchool(gradSchool);
				degree.setName(name);
				degree.setForecast(forecast);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteDegree(String code){
		for(int i=0;i<degrees.size();i++){
			Degree degree=degrees.get(i);
			if(degree.getCode().equals(code)){
				degrees.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Degree getDegree(String code){
		for(Degree degree:degrees){
			if(degree.getCode().equals(code)){
				return degree;
			}
		}
		return null;
	}
}
