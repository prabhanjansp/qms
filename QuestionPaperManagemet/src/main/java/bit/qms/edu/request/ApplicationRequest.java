package bit.qms.edu.request;

import io.vertx.core.json.Json;

public class ApplicationRequest {
	
	private String action;
	private String request;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	
	@Override
	public String toString() {
		return Json.encode(this);
	}

}
