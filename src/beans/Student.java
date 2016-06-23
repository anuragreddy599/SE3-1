package beans;

public class Student {
	
	String id,degreePlan,semester;

	public Student(String id, String degreePlan, String semester) {
		super();
		this.id = id;
		this.degreePlan = degreePlan;
		this.semester = semester;
	}

	public String getId() {
		return id;
	}

	public String getDegreePlan() {
		return degreePlan;
	}

	public String getSemester() {
		return semester;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setDegreePlan(String degreePlan) {
		this.degreePlan = degreePlan;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Override
	public String toString(){
		return this.id+"\n"+this.degreePlan+"\n"+this.semester;
	}

}
