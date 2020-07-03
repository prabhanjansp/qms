package bit.qms.edu.response;

import java.io.Serializable;

public class SubjectResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2630422840431627848L;

	private String subjectID;

	private String subjectName;
	
	private Integer credits;
	
	private Integer semester;
	
	private Integer id;

	public SubjectResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public Integer getCredits() {
		return credits;
	}
	
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	
	public Integer getSemester() {
		return semester;
	}
	
	public void setSemester(Integer semester) {
		this.semester = semester;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

}
