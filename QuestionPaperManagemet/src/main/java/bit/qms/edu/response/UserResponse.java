package bit.qms.edu.response;

import java.io.Serializable;

public class UserResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2664743426830138155L;

	private String name;

	private Integer id;
	
	private String emailId;

	public UserResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

}
