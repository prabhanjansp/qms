
package bit.qms.edu.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bit.qms.edu.model.SubjectModel;

@Repository
public interface Subjectrepo  extends CrudRepository<SubjectModel, Integer>{

	@Query(value = "select s from SubjectModel s where semester=?1")
	public List<SubjectModel> getSubjectsBySemester(Integer semester);
	

	@Query(value = "select s from SubjectModel s where subjectId=?1")
	public List<SubjectModel> getSubjectsBySubjectId(String subjectId);
	
	@Query(value = "select s from SubjectModel s where subjectId=?1 and semester=?2")
	public List<SubjectModel> getSubjectsBySubjectIdAnsSem(String subjectId, Integer semester);
	
	@Query(value = "select s from SubjectModel s where subjectId=?1")
	public SubjectModel getSubject(String subjectId);
	
}
