package bit.qms.edu.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bit.qms.edu.model.TagQuestionModel;

@Repository
public interface TagQuestionRepo extends JpaRepository<TagQuestionModel, Integer> {
	
	
	@Query(value = "select t from TagQuestionModel t where t.subjectCode=?1")
	public List<TagQuestionModel> getTagsBySubject(String subjectCode);
	

	@Query(value = "select t from TagQuestionModel t where t.questionTagName like %?1%")
	public List<TagQuestionModel> getTagsByTagName(String tagName);
	
	

	@Query(value = "select t from TagQuestionModel t where t.subjectCode=?1 and t.questionTagName like %?2%")
	public List<TagQuestionModel> getTags(String subjectCode, String tagName);

}
