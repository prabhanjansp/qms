package bit.qms.edu.response;

import java.io.Serializable;
import java.util.Date;

public class QuestionPaperResponse implements Serializable{
	
	
		

		/**
	 * 
	 */
	private static final long serialVersionUID = -5135663578593442024L;
	
	
		private Integer id;

		private Integer semester;

		private String subject;

		private Date date;

		private String qpType;

		private String filePath;

		private Integer marks;

		private String qpName;

		private String qpFilePath;
		
		private String status;
		
		private String fileId;
		
		private Integer tagId;

		public QuestionPaperResponse() {
			// TODO Auto-generated constructor stub
		}

		public Integer getSemester() {
			return semester;
		}

		public void setSemester(Integer semester) {
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
		
		public Integer getId() {
			return id;
		}
		
		public void setId(Integer id) {
			this.id = id;
		}


		public String getFileId() {
			return fileId;
		}
		
		public void setFileId(String fileId) {
			this.fileId = fileId;
		}
		
		public String getStatus() {
			return status;
		}
		
		public void setStatus(String status) {
			this.status = status;
		}
		
		public Integer getTagId() {
			return tagId;
		}
		
		public void setTagId(Integer tagId) {
			this.tagId = tagId;
		}
}
