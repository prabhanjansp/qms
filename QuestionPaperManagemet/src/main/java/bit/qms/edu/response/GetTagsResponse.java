package bit.qms.edu.response;

import java.util.List;

public class GetTagsResponse {
	
	private List<TagQuestionResponse> tags;
	
	public GetTagsResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public void setTags(List<TagQuestionResponse> tags) {
		this.tags = tags;
	}
	
	public List<TagQuestionResponse> getTags() {
		return tags;
	}

}
