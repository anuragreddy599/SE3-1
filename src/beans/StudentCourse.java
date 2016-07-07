package beans;

public class StudentCourse {

	String studentId,courseCode,courseName,semester,grade;

	public StudentCourse(String studentId, String courseCode,
			String courseName, String semester, String grade) {
		super();
		this.studentId = studentId;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.semester = semester;
		this.grade = grade;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString(){
		return this.studentId+"\n"+this.courseCode+"\n"+this.courseName
				+"\n"+this.semester+"\n"+this.grade;
	}

}
