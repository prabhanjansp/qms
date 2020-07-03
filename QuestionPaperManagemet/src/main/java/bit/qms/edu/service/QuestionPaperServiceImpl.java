package bit.qms.edu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.qms.edu.model.QuestionPaperModel;
import bit.qms.edu.model.SubjectModel;
import bit.qms.edu.request.QuestionPaper;
import bit.qms.edu.response.QuestionPaperGetResponse;
import bit.qms.edu.response.QuestionPaperResponse;
import bit.qms.edu.response.SubjectResponse;
import bit.qms.edu.spring.repo.QuestionPaperRepository;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;

@Service
public class QuestionPaperServiceImpl {

	@Autowired
	private QuestionPaperRepository questionPaperRepository;

	@Transactional
	public QuestionPaperResponse createQuestionPaper(QuestionPaper request) {
		QuestionPaperResponse questionPaperResponse = null;

		String QPName = request.getqpName();

		QuestionPaperModel qmodule = questionPaperRepository.getQuestionPaperModel(QPName);
		if (null == qmodule) {
			
			questionPaperResponse = new QuestionPaperResponse();
			// step 1) create subject model
			QuestionPaperModel model = new QuestionPaperModel();

			// step 2) get data from request object and set it to model
			model.setSemester(request.getSemester());
			model.setQpName(request.getqpName());
			model.setDate(request.getdate());
			model.setSubject(request.getSubject());
			model.setMarks(request.getMarks());
			model.setQpType(request.getQpType());
			model.setTag(new Integer(request.getTagId()));
			model.setStatus("InProgress");
			model.setFileId(UUID.randomUUID().toString());
			// step 3) call repo.save to store the data in database

			model = questionPaperRepository.save(model);

			Vertx vertx = Vertx.currentContext().owner();
			vertx.eventBus().send("generate", Json.encode(model));

			questionPaperResponse.setSemester(model.getSemester());
			questionPaperResponse.setDate(model.getDate());
			questionPaperResponse.setqpName(model.getQpName());
			questionPaperResponse.setQpType(model.getQpType());
			questionPaperResponse.setId(model.getId());
			questionPaperResponse.setStatus(model.getStatus());
			questionPaperResponse.setFileId(model.getFileId());
		}
		return questionPaperResponse;

	}

	public QuestionPaperGetResponse listQuestionPapers() {
		QuestionPaperGetResponse getResponse = new QuestionPaperGetResponse();
		List<QuestionPaperResponse> response = new ArrayList<QuestionPaperResponse>();
		questionPaperRepository.findAll().forEach(model -> {
			QuestionPaperResponse qp = new QuestionPaperResponse();
			qp.setSemester(model.getSemester());
			qp.setDate(model.getDate());
			qp.setqpName(model.getQpName());
			qp.setQpType(model.getQpType());
			qp.setId(model.getId());
			qp.setStatus(model.getStatus());
			qp.setFileId(model.getFileId());
			qp.setSubject(model.getSubject());
			qp.setMarks(model.getMarks());
			qp.setTagId(model.getTag());
			response.add(qp);
		});
		getResponse.setResponses(response);
		return getResponse;
	}

	@Transactional
	public void updateStatus(String status, String path, Integer id) {
		Optional<QuestionPaperModel> model = questionPaperRepository.findById(id);
		if (model.isPresent()) {

			QuestionPaperModel questionPaperModel = model.get();
			questionPaperModel.setStatus(status);
			questionPaperModel.setFilePath(path);
			questionPaperRepository.save(questionPaperModel);
		}
	}
}