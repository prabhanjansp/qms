package bit.qms.edu.response;

import java.util.List;

public class QuestionGetResponse {

	private List<QuestionResponse> responses;

	public QuestionGetResponse() {
	}

	public List<QuestionResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<QuestionResponse> responses) {
		this.responses = responses;
	}
}

