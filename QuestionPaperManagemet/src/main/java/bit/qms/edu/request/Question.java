package bit.qms.edu.request;

import java.util.Date;

public class Question {

	private String questionId;

	private String questionStatement;

	private String subject;

	private Integer marks;

	private String userId;

	private String label;

	private Date createdDt;

	public Question() {
		// TODO Auto-generated constructor stub
	}

	public String getquestionId() {
		return questionId;
	}

	public void setquestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getquestionStatement() {
		return questionStatement;
	}

	public void setquestionStatement(String questionStatement) {
		this.questionStatement = questionStatement;
	}

	public String getsubject() {
		return subject;
	}

	public void setsubject(String subject) {
		this.subject = subject;
	}

	public Integer getmarks() {
		return marks;
	}

	public void setmarks(Integer marks) {
		this.marks = marks;
	}

	public String getuserId() {
		return userId;
	}

	public void setuserId(String userId) {
		this.userId = userId;
	}

	public Date getcreatedDt() {
		return createdDt;
	}

	public void setcreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getlabel() {
		// TODO Auto-generated method stub
		return label;
	}
	public void setlabel(String label)
	{
		this.label=label;
		
	}

}
