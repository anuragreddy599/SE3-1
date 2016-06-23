package beans;

import java.util.ArrayList;

public class DegreeReqs {
	
	String code,requiredHours,electives1Hours,electives2Hours;
	ArrayList<String> Required;
	ArrayList<String> electives1;
	ArrayList<String> electives2;

	public DegreeReqs(String code, String requiredHours,
			String electives1Hours, String electives2Hours,
			ArrayList<String> required, ArrayList<String> electives1,
			ArrayList<String> electives2) {
		super();
		this.code = code;
		this.requiredHours = requiredHours;
		this.electives1Hours = electives1Hours;
		this.electives2Hours = electives2Hours;
		this.Required = required;
		this.electives1 = electives1;
		this.electives2 = electives2;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRequiredHours() {
		return requiredHours;
	}

	public void setRequiredHours(String requiredHours) {
		this.requiredHours = requiredHours;
	}

	public String getElectives1Hours() {
		return electives1Hours;
	}

	public void setElectives1Hours(String electives1Hours) {
		this.electives1Hours = electives1Hours;
	}

	public String getElectives2Hours() {
		return electives2Hours;
	}

	public void setElectives2Hours(String electives2Hours) {
		this.electives2Hours = electives2Hours;
	}

	public ArrayList<String> getRequired() {
		return Required;
	}

	public void setRequired(ArrayList<String> required) {
		Required = required;
	}

	public ArrayList<String> getElectives1() {
		return electives1;
	}

	public void setElectives1(ArrayList<String> electives1) {
		this.electives1 = electives1;
	}

	public ArrayList<String> getElectives2() {
		return electives2;
	}

	public void setElectives2(ArrayList<String> electives2) {
		this.electives2 = electives2;
	}
	
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append(this.code+"\n");
		sb.append(this.requiredHours+"\n");
		sb.append(this.electives1Hours+"\n");
		sb.append(this.electives2Hours+"\n");
		
		for(String course:this.Required){
			sb.append(course);
			sb.append(",");
		}
		sb.append("\n");
		for(String course:this.electives1){
			sb.append(course);
			sb.append(",");
		}
		sb.append("\n");
		for(String course:this.electives2){
			sb.append(course);
			sb.append(",");
		}
		return sb.toString();
	}

}
