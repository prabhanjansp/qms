package bit.qms.edu.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.qms.edu.model.QuestionModel;
import bit.qms.edu.model.TagQuestionModel;
import bit.qms.edu.spring.repo.QuestionRepository;
import bit.qms.edu.spring.repo.TagQuestionRepo;

@Service
public class QuestionPaperGeneratorService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private TagQuestionRepo tagQuestionRepo;
	
	
	/**
	 * 
	 * @param ids
	 * @return
	 */
	public Map<String, QuestionModel> prepareQuestions(Integer tagId) {
		String ids = null;
		
		// Extract Tag model from searching its id
		Optional<TagQuestionModel> model1 = tagQuestionRepo.findById(tagId);
		
		if(model1.isPresent()) {
			TagQuestionModel tagQuestionModel = model1.get();
			
			// Get all questions id present in the tag model
			ids = tagQuestionModel.getQuestions();
			
			System.out.println("Generating question paper with selected tag name:" + tagQuestionModel.getQuestionTagName() +" for the subject :" 
					+ tagQuestionModel.getSubjectCode());
		}
		
		Map<String, QuestionModel> map = new HashMap<String, QuestionModel>();
		
		String[] questionIds = ids.split(",");
		
		if (questionIds.length >0 ) {
			
			for (int i=0;i<questionIds.length;i++) {
				
				Optional<QuestionModel> model =questionRepository.findById(new Integer(questionIds[i]));
				
				if (model.isPresent()) {
					QuestionModel questionModel = model.get();
					System.out.println("Status in map :"+map.containsKey(questionModel.getquestiontId()));
					map.put(questionModel.getquestiontId(), questionModel);
				}
			}
		}
		
		return map;
	}

}
