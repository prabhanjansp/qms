package bit.qms.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.qms.edu.model.SubjectModel;
import bit.qms.edu.request.Subject;
import bit.qms.edu.response.SubjectGetResponse;
import bit.qms.edu.response.SubjectResponse;
import bit.qms.edu.spring.repo.Subjectrepo;

@Service
public class SubjectServiceImpl {

	@Autowired
	private Subjectrepo subjectrepo;

	@Transactional
	public SubjectResponse createSubject(Subject request) {
		SubjectResponse SubjectResponse =null;
		
		String subjectId=request.getsubjectId();
		
		SubjectModel smodule= subjectrepo.getSubject(subjectId);
		if (null == smodule ){
			
			SubjectResponse = new SubjectResponse();

		// step 1) create subject model
		SubjectModel model = new SubjectModel();

		// step 2) get data from request object and set it to model
		model.setSubjectId(request.getsubjectId());
		model.setcredits(request.getcredits());
		model.setSemester(request.getsemester());
		model.setSubjectName(request.getsubjectName());

		// step 3) call repo.save to store the data in database

		model = subjectrepo.save(model);
 
		SubjectResponse.setSubjectID(model.getSubjectId());
		SubjectResponse.setSubjectName(model.getSubjectName());
		}
		return SubjectResponse;

	}
	
	
	@Transactional
	public SubjectGetResponse listSubjects(String subjectId, String semester) {
		Iterable<SubjectModel> models = null;
		SubjectGetResponse getResponse = new SubjectGetResponse();
		List<SubjectResponse> response = new ArrayList<SubjectResponse>();
		if (null != subjectId && null !=semester) {
			
			models = subjectrepo.getSubjectsBySubjectIdAnsSem(subjectId, Integer.valueOf(semester));
			
		} else if (null == subjectId && null != semester) {

			models = subjectrepo.getSubjectsBySemester(Integer.valueOf(semester));

		} else if (null == semester && null != subjectId) {
			models = subjectrepo.getSubjectsBySubjectId(subjectId);
			
		} else {
			models =subjectrepo.findAll();
		}
		if (null != models) {
			models.forEach(model -> {
				SubjectResponse subjectResponse = new SubjectResponse();
				subjectResponse.setSubjectName(model.getSubjectName());
				subjectResponse.setSubjectID(model.getSubjectId());
				subjectResponse.setCredits(model.getcredits());
				subjectResponse.setSemester(model.getSemester());
				subjectResponse.setId(model.getId());
				response.add(subjectResponse);
			});
		}
		getResponse.setResponses(response);
		return getResponse;
	}

	@Transactional
	public Integer deleteSubject(Integer id) {
		subjectrepo.deleteById(id);
		return id;
	}
	
	@Transactional
	public String getSubjectName(String id) {
		String name = null;
		SubjectModel model = subjectrepo.getSubject(id);
		if (null != model) {
			name = model.getSubjectName();
		}
		return name;
	}
}
