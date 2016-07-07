package registers;

import java.util.ArrayList;

import beans.DegreeReqs;

public class DegreeReqsRegister {

	private static DegreeReqsRegister degreeReqRegister=new DegreeReqsRegister();
	public static ArrayList<DegreeReqs> degreeReqs;

	public ArrayList<DegreeReqs> getAllDegreeReqs() {
		return degreeReqs;
	}

	private DegreeReqsRegister(){
		degreeReqs=new ArrayList<DegreeReqs>();
	}

	public static DegreeReqsRegister getInstance(){
		return degreeReqRegister;
	}

	public void addDegreeReqs(String code, String requiredHours,
			String electives1Hours, String electives2Hours,
			ArrayList<String> required, ArrayList<String> electives1,
			ArrayList<String> electives2){
		DegreeReqs degreeReq=new DegreeReqs(code,requiredHours,electives1Hours,electives2Hours,required,electives1,electives2);
		degreeReqs.add(degreeReq);
	}

	public boolean editDegreeReqs(String code, String requiredHours,
			String electives1Hours, String electives2Hours,
			ArrayList<String> required, ArrayList<String> electives1,
			ArrayList<String> electives2){		
		
		for(int i=0;i<degreeReqs.size();i++){
			DegreeReqs degreeReq=degreeReqs.get(i);			
			if(degreeReq.getCode().equals(code)){
				degreeReq.setCode(code);
				degreeReq.setRequiredHours(requiredHours);
				degreeReq.setElectives1Hours(electives1Hours);
				degreeReq.setElectives2Hours(electives2Hours);
				degreeReq.setRequired(required);
				degreeReq.setElectives1(electives1);
				degreeReq.setElectives2(electives2);
				return true;
			}
		}
		return false;
	}

	public boolean deleteDegreeReqs(String code){
		for(int i=0;i<degreeReqs.size();i++){
			DegreeReqs degreeReq=degreeReqs.get(i);
			if(degreeReq.getCode().equals(code)){
				degreeReqs.remove(i);
				return true;
			}
		}
		return false;
	}

	public DegreeReqs getDegreeReqs(String code){
		for(DegreeReqs degreeReq:degreeReqs){
			if(degreeReq.getCode().equals(code)){
				return degreeReq;
			}
		}
		return null;
	}

}
