package bit.qms.edu.response;

import java.util.List;

public class QuestionPaperGetResponse {

	private List<QuestionPaperResponse> responses;

	public QuestionPaperGetResponse() {
	}

	public List<QuestionPaperResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<QuestionPaperResponse> responses) {
		this.responses = responses;
	}
}
