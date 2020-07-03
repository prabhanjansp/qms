package bit.qms.edu.response;

public class TagQuestionResponse {
	
	private String id;
	
	private String questionTagName;
	
	private String subjectCode;
	
	private String questionIds;
	
	public TagQuestionResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestionTagName() {
		return questionTagName;
	}

	public void setQuestionTagName(String questionTagName) {
		this.questionTagName = questionTagName;
	}
	

	public String getSubjectCode() {
		return subjectCode;
	}
	
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	
	public String getQuestionIds() {
		return questionIds;
	}
	
	public void setQuestionIds(String questionIds) {
		this.questionIds = questionIds;
	}

}
