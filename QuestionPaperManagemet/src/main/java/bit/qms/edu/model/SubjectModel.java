package bit.qms.edu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_SUBJECT")

public class SubjectModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer Id;

	@Column(name = "subject_id")
	private String subjectId;

	@Column(name = "subject_name")
	private String subjectName;

	@Column(name = "semester")
	private Integer semester;

	@Column(name = "credits")
	private Integer credits;

	public SubjectModel() {

	}

	public String getSubjectId() {
		return subjectId;

	}

	public void setSubjectId(String SubjectId) {
		this.subjectId = SubjectId;

	}

	public String getSubjectName() {
		return subjectName;

	}

	public void setSubjectName(String SubjectName) {
		this.subjectName = SubjectName;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer Semester) {
		this.semester = Semester;
	}

	public Integer getcredits() {
		return credits;
	}

	public void setcredits(Integer credits) {
		this.credits = credits;
	}
	
	public Integer getId() {
		return Id;
	}

}
