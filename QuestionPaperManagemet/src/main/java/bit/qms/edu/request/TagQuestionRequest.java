package bit.qms.edu.request;

import java.io.Serializable;

public class TagQuestionRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String questions;
	
	private String subjectCode;
	
	private String userId;
	
	private String questionTagName;
	
	public TagQuestionRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getQuestionTagName() {
		return questionTagName;
	}

	public void setQuestionTagName(String questionTagName) {
		this.questionTagName = questionTagName;
	}
	
	

}
