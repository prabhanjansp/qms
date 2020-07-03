package bit.qms.edu.paper;

import java.util.Map;

import bit.qms.edu.configuration.QMSContext;
import bit.qms.edu.model.QuestionModel;
import bit.qms.edu.model.QuestionPaperModel;
import bit.qms.edu.service.QuestionPaperGeneratorService;

public class ExternalPaperGenerator {

	public static final String[] questionOrdering = { "1.a", "1.b", "1.c", "2.a", "2.b", "2.c", "3.a", "3.b", "3.c",
			"4.a", "4.b", "4.c", "5.a", "5.b", "5.c" };

	public void generate(QuestionPaperModel model) {
		// TODO Auto-generated method stub
		
		QuestionPaperGeneratorService generatorService =QMSContext.getApplicationContext().getBean(QuestionPaperGeneratorService.class);
		
		Map<String, QuestionModel>  questionsMap = generatorService.prepareQuestions(model.getTag());
		
		for (int i=0; i< questionOrdering.length; i++) {
			QuestionModel question =questionsMap.get(questionOrdering[i]);
			
			if (null == question) {
				System.out.println("Could not get question for " + questionOrdering[i]);
				continue;
			} else {
				System.out.println("Adding question :" + question.getquestionStatement() + " with the ordering :" + question.getquestiontId() + " having marks:" +question.getmarks());
			}
		}


	}

}
