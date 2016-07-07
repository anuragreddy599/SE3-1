package beans;

public class Faculty {

	String lname,fname,school,degree,title,days,maxLoadFA,maxLoadSP,maxLoadSU;
        
        String courses;
	int load;

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

	public Faculty(String lname, String fname, String school, String degree,
			String title, String days, String maxLoadFA, String maxLoadSP,
			String maxLoadSU) {
		super();
		this.lname = lname;
		this.fname = fname;
		this.school = school;
		this.degree = degree;
		this.title = title;
		this.days = days;
		this.maxLoadFA = maxLoadFA;
		this.maxLoadSP = maxLoadSP;
		this.maxLoadSU = maxLoadSU;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getMaxLoadFA() {
		return maxLoadFA;
	}

	public void setMaxLoadFA(String maxLoadFA) {
		this.maxLoadFA = maxLoadFA;
	}

	public String getMaxLoadSP() {
		return maxLoadSP;
	}

	public void setMaxLoadSP(String maxLoadSP) {
		this.maxLoadSP = maxLoadSP;
	}

	public String getMaxLoadSU() {
		return maxLoadSU;
	}

	public void setMaxLoadSU(String maxLoadSU) {
		this.maxLoadSU = maxLoadSU;
	}

	@Override
	public String toString(){
		return this.lname+"\n"+this.fname+"\n"+this.school+"\n"+this.degree+"\n"
				+this.title+"\n"+this.days+"\n"+this.maxLoadFA+"\n"+this.maxLoadSP+"\n"
				+this.maxLoadSU;
	}

}
