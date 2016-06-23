package beans;

import java.util.ArrayList;

public class Course {

	String code,name,desc,hour,cap,offeredFA,offeredSP,offeredSU;
	ArrayList<String> preReqs,teachers;

	public Course(String code, String name, String desc, String hour,
			String cap, String offeredFA, String offeredSP, String offeredSU,
			ArrayList<String> preReqs, ArrayList<String> teachers) {
		super();
		this.code = code;
		this.name = name;
		this.desc = desc;
		this.hour = hour;
		this.cap = cap;
		this.offeredFA = offeredFA;
		this.offeredSP = offeredSP;
		this.offeredSU = offeredSU;
		if(!preReqs.get(0).equalsIgnoreCase("none")){
			this.preReqs = preReqs;
		}
		this.teachers = teachers;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getOfferedFA() {
		return offeredFA;
	}

	public void setOfferedFA(String offeredFA) {
		this.offeredFA = offeredFA;
	}

	public String getOfferedSP() {
		return offeredSP;
	}

	public void setOfferedSP(String offeredSP) {
		this.offeredSP = offeredSP;
	}

	public String getOfferedSU() {
		return offeredSU;
	}

	public void setOfferedSU(String offeredSU) {
		this.offeredSU = offeredSU;
	}

	public ArrayList<String> getTeachers() {
		return teachers;
	}

	public void setTeachers(ArrayList<String> teachers) {
		this.teachers = teachers;
	}

	public ArrayList<String> getPreReqs() {
		return preReqs;
	}

	public void setPreReqs(ArrayList<String> preReqs) {
		this.preReqs = preReqs;
	}

	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append(this.code+"\n");
		sb.append(this.name+"\n");
		sb.append(this.desc+"\n");
		sb.append(this.hour+"\n");
		sb.append(this.cap+"\n");
		sb.append(this.offeredFA+"\n");
		sb.append(this.offeredSP+"\n");
		sb.append(this.offeredSU);

		if(this.preReqs!=null){
			sb.append("\n");
			for(String preReq:this.preReqs){
				sb.append(preReq);
				sb.append(",");
			}
		}
		
		sb.append("\n");
		for(String teacher:this.teachers){
			sb.append(teacher);
			sb.append(",");
		}
		return sb.toString();
	}

}
