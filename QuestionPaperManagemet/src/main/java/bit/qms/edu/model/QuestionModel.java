package bit.qms.edu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_QUESTION")

public class QuestionModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer Id;

	@Column(name = "question_id")
	private String questiontId;

	@Column(name = " question_statement")
	private String  questionStatement;

	@Column(name = "subject")
	private String subject;

	@Column(name = "marks")
	private Integer marks;
	
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "label")
	private String label;

	
	@Column(name = "created_dt")
	private Date createdDt;

	public QuestionModel() {

	}

	public String getquestiontId() {
		return questiontId;

	}

	public void setQuestiontId(String string) {
		this.questiontId = string;

	}

	public String getquestionStatement() {
		return questionStatement;

	}

	public void setquestionStatement(String questionStatement) {
		this.questionStatement =questionStatement;
	}
	
	public String getsubject()
	{
		return subject;
	}
	
	public void setsubject(String subject)
	{
		this.subject=subject;
	}

	public Integer getmarks() {
		return marks;
	}

	public void setmarks(Integer marks) {
		this.marks = marks;
	}

	public String getUsername() {
		return username;
	}

	public void setUserName(String username) {
		this.username =username;
	}

	public String getlabel() {
		return label;
	}

	public void setlabel(String label) {
		this.label = label;
	}
	
	public Date getcreatedDt() {
		return createdDt;
	}

	public void setcreatedDt(Date createdDt) {
		this.createdDt = createdDt;}
	
	public Integer getId() {
		return Id;
	}
	
}
