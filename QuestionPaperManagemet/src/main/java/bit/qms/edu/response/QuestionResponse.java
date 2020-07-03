package bit.qms.edu.response;

import java.io.Serializable;
import java.util.Date;

public class QuestionResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -955358285742557773L;

	private String questionID;

	private String questionStatement;

	private String subject;

	private Integer marks;

	private String username;;

	private String label;

	private Date createdDT;
	
	private Integer id;

	public QuestionResponse() {

	}

	public String getquestionID() {
		return questionID;
	}

	public void setquestionID(String questionID) {
		this.questionID = questionID;
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

	public  void setsubject(String subject) {
		this.subject = subject;
	}

	public Integer getmarks() {
		return marks;
	}

	public  void setmarks(Integer marks) {
		this.marks = marks;
	}

	public String getusername() {
		return username;
	}

	public void setuserID(String username) {
		this.username = username;
	}

	public String getlabel() {
		return label;
	}

	public void setlabel(String label) {
		this.label = label;
	}

	public Date getcreatedDT() {
		return createdDT;
	}

	public void setcreatedDT(Date createdDT) {
		this.createdDT = createdDT;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}
