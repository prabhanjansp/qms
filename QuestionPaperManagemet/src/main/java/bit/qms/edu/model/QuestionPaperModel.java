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
@Table(name = "T_QMP")

public class QuestionPaperModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer Id;

	@Column(name = "semester")
	private Integer semester;

	@Column(name = "subject")
	private String subject;

	@Column(name = "date")
	private Date date;

	@Column(name = "qpType")
	private String qpType;

	@Column(name = "qp_file_path")
	private String filePath;

	@Column(name = "marks")
	private Integer marks;

	@Column(name = "qpName")
	private String qpName;
	
	@Column(name="status")
	private String status;
	
	@Column(name="file_id")
	private String fileId;
	
	@Column(name="tag_id")
	private Integer tag;
	

	public QuestionPaperModel() {

	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
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

	public Date getDate() {
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

	public String getQpName() {
		return qpName;
	}

	public void setQpName(String qpName) {
		this.qpName = qpName;
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
	
	public Integer getTag() {
		return tag;
	}
	
	public void setTag(Integer tag) {
		this.tag = tag;
	}

}
