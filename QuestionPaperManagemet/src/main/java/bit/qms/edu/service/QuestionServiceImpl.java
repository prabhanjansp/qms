package bit.qms.edu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import bit.qms.edu.model.QuestionModel;
import bit.qms.edu.model.TagQuestionModel;
import bit.qms.edu.request.Question;
import bit.qms.edu.request.TagQuestionRequest;
import bit.qms.edu.response.QuestionResponse;
import bit.qms.edu.response.TagQuestionResponse;
import bit.qms.edu.spring.repo.QuestionRepository;
import bit.qms.edu.spring.repo.TagQuestionRepo;
import bit.qms.edu.response.GetTagsResponse;
import bit.qms.edu.response.QuestionGetResponse;

@Service
public class QuestionServiceImpl {
	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private TagQuestionRepo tagQuestionRepo;

	@Transactional
	public QuestionResponse createQuestion(Question request) {
		QuestionResponse QuestionResponse = new QuestionResponse();

		// step 1) create subject model
		QuestionModel model = new QuestionModel();

		// step 2) get data from request object and set it to model
		model.setquestionStatement(request.getquestionStatement());
		model.setsubject(request.getsubject());
		model.setmarks(request.getmarks());
		model.setUserName(request.getuserId());
		model.setlabel(request.getlabel());
		model.setQuestiontId(request.getquestionId());
		model.setcreatedDt(new Date());

		// step 3) call repo.save to store the data in database

		model = questionRepository.save(model);

		QuestionResponse.setquestionID(model.getquestiontId());
		QuestionResponse.setquestionStatement(model.getquestionStatement());

		return QuestionResponse;

	}

	@Transactional
	public QuestionGetResponse listQuestions(Integer id, String subjectCode) {
		QuestionGetResponse getResponse = new QuestionGetResponse();
		List<QuestionResponse> response = new ArrayList<QuestionResponse>();

		if (null != id && null == subjectCode) {
			response.add(getById(id));

		} else if (null == id && null != subjectCode) {
			response.add(getBySubject(subjectCode));

		} else {
			questionRepository.findAll().forEach(model -> {
				QuestionResponse questionResponse = new QuestionResponse();
				questionResponse.setquestionStatement(model.getquestionStatement());
				questionResponse.setsubject(model.getsubject());
				questionResponse.setmarks(model.getmarks());
				questionResponse.setId(model.getId());
				questionResponse.setuserID(model.getUsername());
				questionResponse.setlabel(model.getlabel());
				questionResponse.setquestionID(model.getquestiontId());
				questionResponse.setcreatedDT(model.getcreatedDt());

				response.add(questionResponse);
			});
		}
		getResponse.setResponses(response);
		return getResponse;
	}

	@Transactional
	public Integer deleteQuestion(Integer id) {
		questionRepository.deleteById(id);
		return id;
	}

	@Transactional
	public QuestionResponse getById(Integer id) {
		Optional<QuestionModel> questionModel = questionRepository.findById(id);
		QuestionResponse questionResponse = new QuestionResponse();
		if (questionModel.isPresent()) {
			QuestionModel model = questionModel.get();
			questionResponse.setquestionStatement(model.getquestionStatement());
			questionResponse.setsubject(model.getsubject());
			questionResponse.setmarks(model.getmarks());
			questionResponse.setId(model.getId());
			questionResponse.setuserID(model.getUsername());
			questionResponse.setlabel(model.getlabel());
			questionResponse.setquestionID(model.getquestiontId());
			questionResponse.setcreatedDT(model.getcreatedDt());
		}
		return questionResponse;
	}

	public QuestionResponse getBySubject(String id) {
		QuestionModel model = questionRepository.getBySubject(id);
		QuestionResponse questionResponse = new QuestionResponse();
		if (null != model) {
			questionResponse.setquestionStatement(model.getquestionStatement());
			questionResponse.setsubject(model.getsubject());
			questionResponse.setmarks(model.getmarks());
			questionResponse.setId(model.getId());
			questionResponse.setuserID(model.getUsername());
			questionResponse.setlabel(model.getlabel());
			questionResponse.setquestionID(model.getquestiontId());
			questionResponse.setcreatedDT(model.getcreatedDt());
		}
		return questionResponse;
	}

	/**
	 * 
	 * @param questionRequest
	 * @return
	 */
	public TagQuestionResponse tagQuestions(TagQuestionRequest questionRequest) {

		TagQuestionModel model = new TagQuestionModel();

		model.setDate(new Date());
		model.setQuestions(questionRequest.getQuestions());
		model.setQuestionTagName(questionRequest.getQuestionTagName());
		model.setSubjectCode(questionRequest.getSubjectCode());
		model.setUserId(questionRequest.getUserId());

		model = tagQuestionRepo.save(model);

		TagQuestionResponse tagQuestionResponse = new TagQuestionResponse();
		tagQuestionResponse.setId(model.getId().toString());
		tagQuestionResponse.setQuestionTagName(model.getQuestionTagName());

		return tagQuestionResponse;
	}

	public GetTagsResponse listTags(String subjectCode, String tag) {

		GetTagsResponse response = new GetTagsResponse();
		List<TagQuestionResponse> tags = new ArrayList<TagQuestionResponse>();
		List<TagQuestionModel> tagModels = null;

		if (null == subjectCode && null == tag) {
			tagQuestionRepo.findAll().forEach(model -> {
				TagQuestionResponse questionResponse = new TagQuestionResponse();
				questionResponse.setId(model.getId().toString());
				questionResponse.setSubjectCode(model.getSubjectCode());
				questionResponse.setQuestionTagName(model.getQuestionTagName());
				questionResponse.setQuestionIds(model.getQuestions());
				tags.add(questionResponse);
			});
		}

		if (null == subjectCode && null != tag) {
			tagModels = tagQuestionRepo.getTagsByTagName(tag);
		}

		if (null != subjectCode && null == tag) {
			tagModels = tagQuestionRepo.getTagsBySubject(subjectCode);

		}

		if (null != subjectCode && null != tag) {
			tagModels = tagQuestionRepo.getTags(subjectCode, tag);
		}

		if (!CollectionUtils.isEmpty(tagModels)) {
			tagModels.forEach(model -> {
				TagQuestionResponse questionResponse = new TagQuestionResponse();
				questionResponse.setId(model.getId().toString());
				questionResponse.setSubjectCode(model.getSubjectCode());
				questionResponse.setQuestionTagName(model.getQuestionTagName());
				questionResponse.setQuestionIds(model.getQuestions());
				tags.add(questionResponse);
			});
		}

		response.setTags(tags);

		return response;

	}

	public TagQuestionResponse getTagById(String tagId) {
		Optional<TagQuestionModel> questionModel = tagQuestionRepo.findById(new Integer(tagId.trim()));
		TagQuestionResponse questionResponse = new TagQuestionResponse();
		if (questionModel.isPresent()) {
			TagQuestionModel model = questionModel.get();
			questionResponse.setId(model.getId().toString());
			questionResponse.setSubjectCode(model.getSubjectCode());
			questionResponse.setQuestionTagName(model.getQuestionTagName());
			questionResponse.setQuestionIds(model.getQuestions());
		}
		return questionResponse;
	}
}
