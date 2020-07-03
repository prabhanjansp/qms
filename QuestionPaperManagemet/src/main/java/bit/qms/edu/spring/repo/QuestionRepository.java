
package bit.qms.edu.spring.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bit.qms.edu.model.QuestionModel;

@Repository
public interface QuestionRepository  extends CrudRepository<QuestionModel, Integer>{
	
	@Query("select q from QuestionModel q where q.subject=?1")
	public QuestionModel getBySubject(String subject);
	
}
