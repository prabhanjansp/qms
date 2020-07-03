package bit.qms.edu.verticle;

import org.springframework.dao.EmptyResultDataAccessException;

import bit.qms.edu.configuration.QMSContext;
import bit.qms.edu.model.UserModel;
import bit.qms.edu.request.Question;
import bit.qms.edu.request.QuestionPaper;
import bit.qms.edu.request.Subject;
import bit.qms.edu.request.TagQuestionRequest;
import bit.qms.edu.request.UserRequest;
import bit.qms.edu.response.GetTagsResponse;
import bit.qms.edu.response.QuestionGetResponse;
import bit.qms.edu.response.QuestionPaperGetResponse;
import bit.qms.edu.response.QuestionPaperResponse;
import bit.qms.edu.response.QuestionResponse;
import bit.qms.edu.response.SubjectGetResponse;
import bit.qms.edu.response.SubjectResponse;
import bit.qms.edu.response.TagQuestionResponse;
import bit.qms.edu.response.UserResponse;
import bit.qms.edu.service.QuestionPaperServiceImpl;
import bit.qms.edu.service.QuestionServiceImpl;
import bit.qms.edu.service.SubjectServiceImpl;
import bit.qms.edu.service.UserServiceImpl;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * Verticle for all the rest web services
 * 
 * @author puran
 *
 */
public class QMSWorkerVerticle extends AbstractVerticle {

	@Override
	public void start(Future<Void> startFuture) throws Exception {

		Router router = Router.router(vertx);
		router.post().handler(BodyHandler.create());
		router.put().handler(BodyHandler.create());
		router.route("/").handler(this::welcomeMessage);

		router.route(HttpMethod.POST, "/qms/user").handler(this::createUser);
		router.route(HttpMethod.POST, "/qms/login").handler(this::login);

		router.route(HttpMethod.POST, "/qms/subject").handler(this::createSubject);
		router.route(HttpMethod.GET, "/qms/subject").handler(this::listAllSubjects);
		router.route(HttpMethod.DELETE, "/qms/subject/:id").handler(this::deleteSubject);

		router.route(HttpMethod.POST, "/qms/questions").handler(this::createQuestion);
		router.route(HttpMethod.GET, "/qms/questions").handler(this::listAllQuestions);
		router.route(HttpMethod.DELETE, "/qms/questions/:id").handler(this::deleteQuestion);
		
		router.route(HttpMethod.POST,"/qms/questions/tag").handler(this::tagQuestions);
		router.route(HttpMethod.GET,"/qms/questions/tag").handler(this::listTags);
		router.route(HttpMethod.GET, "/qms/questions/tag/:tagid").handler(this::validateTag);

		router.route(HttpMethod.POST, "/qms/paper").handler(this::createQuestionPaper);
        router.route(HttpMethod.GET, "/qms/paper").handler(this::listAlLQuestionPaper);
		vertx.createHttpServer().requestHandler(router::accept).listen(8080, result -> {
			if (result.succeeded()) {
				System.out.println("Server created!!");
				startFuture.complete();
			} else {
				System.out.println(result.toString());
				startFuture.fail("server creation failed");
			}
		});
	}

	/**
	 * 
	 * @param context
	 */
	private void welcomeMessage(RoutingContext context) {
		JsonObject responseMessage = new JsonObject();
		responseMessage.put("status", "QMS Api is up and running!!");
		context.response().setStatusCode(200).end(responseMessage.encode());
	}

	/**
	 * 
	 * @param context
	 */
	private void login(RoutingContext context) {

		String email = context.getBodyAsJson().getString("email");

		String password = context.getBodyAsJson().getString("password");

		UserModel model = getUserService().getUser(email, password);

		if (null != model) {

			context.response().setStatusCode(200).end(Json.encode(model));
		} else {
			JsonObject jsonObject = new JsonObject();
			jsonObject.put("message", "User not found");
			context.response().setStatusCode(200).end(Json.encode(jsonObject));
		}

	}

	////// Utility methods start

	/**
	 * create user method
	 * 
	 * @param context
	 */
	private void createUser(RoutingContext context) {
		// Context.getBodyAsString - gets data from http request
		// gets data from http body and creates an object of class UserRequest
		UserRequest request = Json.decodeValue(context.getBodyAsString(), UserRequest.class);
		UserResponse response = getUserService().createUser(request); //
		context.response().setStatusCode(201).end(Json.encode(response));
	}

	/**
	 * create subject method
	 * 
	 * @param context
	 */
	private void createSubject(RoutingContext context) {
		Subject subject = Json.decodeValue(context.getBodyAsString(), Subject.class);
		SubjectResponse response = getsubjectService().createSubject(subject);
		if (null == response) {
			context.response().setStatusCode(200).end();
		} else {
			context.response().setStatusCode(201).end(Json.encode(response));	
		}
	}

	private void listAllSubjects(RoutingContext context) {
		String semester = context.request().getParam("semester");
		String subjectId = context.request().getParam("subjectId");
		SubjectGetResponse response = getsubjectService().listSubjects(subjectId, semester);
		context.response().setStatusCode(200).end(Json.encode(response));
	}

	private void deleteSubject(RoutingContext context) {
		Integer id = new Integer(context.request().getParam("id"));
		try {
			id = getsubjectService().deleteSubject(id);
			JsonObject response = new JsonObject();
			response.put("id", id);
			context.response().setStatusCode(200).end(Json.encode(response));
		} catch (EmptyResultDataAccessException e) {
			JsonObject response = new JsonObject();
			response.put("msg", "Data not found for deletion");

			context.response().setStatusCode(200).end(Json.encode(response));
		}
	}

	/**
	 * create question method
	 * 
	 * @param context
	 */

	private void createQuestion(RoutingContext context) {
		Question question = Json.decodeValue(context.getBodyAsString(), Question.class);
		QuestionResponse response = getquestionservice().createQuestion(question);
		context.response().setStatusCode(201).end(Json.encode(response));
		
		if (null == response) {
			context.response().setStatusCode(200).end();
		} else {
			context.response().setStatusCode(201).end(Json.encode(response));	
		}
	

	}

	private void listAllQuestions(RoutingContext context) {
		Integer id = null;
		if (null != context.request().getParam("id")) {
			id = new Integer(context.request().getParam("id"));

		}
		String  subject = context.request().getParam("subject");

		QuestionGetResponse response = getquestionservice().listQuestions(id,subject);

		context.response().setStatusCode(200).end(Json.encode(response));
	}
	
	private void tagQuestions(RoutingContext context) {
		TagQuestionRequest request = Json.decodeValue(context.getBodyAsString(), TagQuestionRequest.class);
		TagQuestionResponse  tagQuestionResponse= getquestionservice().tagQuestions(request);
		context.response().setStatusCode(200).end(Json.encode(tagQuestionResponse));
	}

	private void listTags(RoutingContext context) {
		String tag = context.request().getParam("tag");
		String subjectCode = context.request().getParam("subject");
		GetTagsResponse response = getquestionservice().listTags(subjectCode, tag);
		context.response().setStatusCode(200).end(Json.encode(response));
	}
	
	private void validateTag(RoutingContext context) {
		String tag = context.request().getParam("tagid");
		TagQuestionResponse  tagQuestionResponse= getquestionservice().getTagById(tag);
		context.response().setStatusCode(200).end(Json.encode(tagQuestionResponse));
	}
	
	private void deleteQuestion(RoutingContext context) {
		Integer id = new Integer(context.request().getParam("id"));
		try {
			id = getquestionservice().deleteQuestion(id);
			JsonObject response = new JsonObject();
			response.put("id", id);
			context.response().setStatusCode(200).end(Json.encode(response));
		} catch (EmptyResultDataAccessException e) {
			JsonObject response = new JsonObject();
			response.put("msg", "Data not found for deletion");

			context.response().setStatusCode(200).end(Json.encode(response));
		}
	}

	private void createQuestionPaper(RoutingContext context) {
		QuestionPaper questionPaper = Json.decodeValue(context.getBodyAsString(), QuestionPaper.class);
		QuestionPaperResponse questionPaperResponse = getQuestionPaperServiceImpl().createQuestionPaper(questionPaper);
		
		if (null == questionPaperResponse) {
			context.response().setStatusCode(200).end();
		} else {
			context.response().setStatusCode(200).end(Json.encode(questionPaperResponse));
		}
	}

	
	private void listAlLQuestionPaper(RoutingContext context) {
		QuestionPaperGetResponse response = getQuestionPaperServiceImpl().listQuestionPapers();
		context.response().setStatusCode(200).putHeader("content-type", "application/json").end(Json.encode(response));
	}

	/**
	 * create question paper method
	 * 
	 * @param context
	 */

	////// Utility methods end

	// Business logic services methods start
	/**
	 * Returns a Business Service which runs logic
	 * 
	 * @return
	 */
	public UserServiceImpl getUserService() {
		return QMSContext.getApplicationContext().getBean(UserServiceImpl.class);
	}

	/**
	 * 
	 * @return
	 */
	private SubjectServiceImpl getsubjectService() {  //make sure it 
		return QMSContext.getApplicationContext().getBean(SubjectServiceImpl.class);
	}

	/**
	 * 
	 * @param context
	 */
	private QuestionServiceImpl getquestionservice() {
		return QMSContext.getApplicationContext().getBean(QuestionServiceImpl.class);
	}

	// Business logic services methods start

	private QuestionPaperServiceImpl getQuestionPaperServiceImpl() {

		return QMSContext.getApplicationContext().getBean(QuestionPaperServiceImpl.class);
	}

}
