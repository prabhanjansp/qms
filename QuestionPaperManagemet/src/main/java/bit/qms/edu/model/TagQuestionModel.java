package bit.qms.edu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_QUESTIONS_TAG")
public class TagQuestionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="questions")
	private String questions;
	
	@Column(name="subject_code")
	private String subjectCode;
	
	@Column(name="created_dt")
	private Date date;
	
	@Column(name="created_userid")
	private String userId;
	
	@Column(name="question_tag_name")
	private String questionTagName;
	
	
	public TagQuestionModel() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
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
