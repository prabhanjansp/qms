package bit.qms.edu.paper;

import java.util.Map;

import bit.qms.edu.configuration.QMSContext;
import bit.qms.edu.model.QuestionModel;
import bit.qms.edu.model.QuestionPaperModel;
import bit.qms.edu.service.GeneratePaperServiceImpl;
import bit.qms.edu.service.QuestionPaperGeneratorService;
import bit.qms.edu.service.QuestionPaperServiceImpl;
import bit.qms.edu.service.SubjectServiceImpl;

public class InternalPaperGenerator {
	
	public static final String[] questionOrdering = {"1.a" , "1.b" ,"1.c" ,"2.a" ,"2.b" ,"2.c" ,"3.a" ,"3.b" ,"3.c" };

	public void generate(QuestionPaperModel model) {

		QuestionPaperGeneratorService generatorService =QMSContext.getApplicationContext().getBean(QuestionPaperGeneratorService.class);
	
		Map<String, QuestionModel>  questionsMap = generatorService.prepareQuestions(model.getTag());
		
		String subject = QMSContext.getApplicationContext().getBean(SubjectServiceImpl.class).getSubjectName(model.getSubject());
		GeneratePaperServiceImpl generatePaperServiceImpl = new GeneratePaperServiceImpl();
		String path = generatePaperServiceImpl.generate(model.getFileId(),questionsMap, model.getSubject(),subject,model.getDate().toLocaleString());
		/*
		 * for (int i=0; i< questionOrdering.length; i++) { QuestionModel question
		 * =questionsMap.get(questionOrdering[i]);
		 * 
		 * if (null == question) { System.out.println("Could not get question for " +
		 * questionOrdering[i]); continue; } else {
		 * System.out.println("Adding question :" + question.getquestionStatement() +
		 * " with the ordering :" + question.getquestiontId() + " having marks:"
		 * +question.getmarks()); } }
		 */
		
		
		QMSContext.getApplicationContext().getBean(QuestionPaperServiceImpl.class).updateStatus("Completed",path, model.getId());
		
	}

}
