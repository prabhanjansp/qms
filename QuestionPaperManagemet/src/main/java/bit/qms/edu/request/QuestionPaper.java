package bit.qms.edu.request;

import java.util.Date;

public class QuestionPaper {

	private Integer semester;

	private String subject;

	private Date date;

	private String qpType;

	private String filePath;

	private Integer marks;

	private String qpName;

	private String qpFilePath;
	
	private String tagId;

	public QuestionPaper() {
		// TODO Auto-generated constructor stub
	}

	public Integer getSemester() {
		return semester;
	}

	public void Setsemester(Integer semester) {
		this.semester = semester;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getdate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getQpType() {
		return qpType;
	}

	public void setQpType(String qpType) {
		this.qpType = qpType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public String getqpName() {
		return qpName;
	}

	public void setqpName(String qpName) {
		this.qpName = qpName;
	}

	public String getqpFilePath() {
		return qpFilePath;
	}

	public void setqpFilePath(String qpFilePath) {
		this.qpFilePath = qpFilePath;
	}

	public String getTagId() {
		return tagId;
	}
	
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
}