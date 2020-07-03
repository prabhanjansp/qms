package bit.qms.edu.spring.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bit.qms.edu.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {
	
	
	@Query(value = "select u from UserModel u where u.email=?1 and u.password=?2")
	public UserModel getUser(String email,String password);

}
