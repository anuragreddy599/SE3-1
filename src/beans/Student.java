package beans;

public class Student {
	
	String id,degreePlan,semester;
        private String[] courseNum;
	private String[] courseName;
	private String[] courseSemester;
	private String[] grade;
	private int coursesCleared;
	private int coursesToClear;

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
        public int getCoursesCleared() {
		return coursesCleared;
	}
	public void setCoursesCleared(int coursesCleared) {
		this.coursesCleared = coursesCleared;
	}
	
	public int getCoursesToClear() {
		return coursesToClear;
	}
	public void setCoursesToClear(int coursesToClear) {
		this.coursesToClear = coursesToClear;
	}
	public String[] getGrade() {
		return grade;
	}
	public void setGrade(String[] grade) {
		this.grade = grade;
	}
	
	public String[] getCourseNum() {
		return courseNum;
	}
	public void setCourseNum(String[] courseNum) {
		this.courseNum = courseNum;
	}
	public String[] getCourseName() {
		return courseName;
	}
	public void setCourseName(String[] courseName) {
		this.courseName = courseName;
	}
	public String[] getCourseSemester() {
		return courseSemester;
	}
	public void setCourseSemester(String[] courseSemester) {
		this.courseSemester = courseSemester;
	}
}
