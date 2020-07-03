package bit.qms.edu.request;

public class Subject {

	private String subjectId;

	private String subjectName;

	private Integer credits;

	private Integer semester;
	
	public Subject() {
		// TODO Auto-generated constructor stub
	}
	
	public String getsubjectId() {
		return subjectId;
	}

	public void setsubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getsubjectName() {
		return subjectName;
	}

	public void setsubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getcredits() {
		return credits;
	}

	public void setcredits(Integer credits) {
		this.credits = credits;
	}

	public Integer getsemester() {
		return semester;
	}

	public void setsemester(Integer semester) {
		this.semester = semester;
	}
}
