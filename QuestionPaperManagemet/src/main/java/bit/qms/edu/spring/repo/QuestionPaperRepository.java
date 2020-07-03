
package bit.qms.edu.spring.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bit.qms.edu.model.QuestionPaperModel;

@Repository
public interface QuestionPaperRepository  extends CrudRepository<QuestionPaperModel, Integer>{

	@Query(value = "select s from QuestionPaperModel s where s.qpName=?1")
	public QuestionPaperModel getQuestionPaperModel(String QPName);

}