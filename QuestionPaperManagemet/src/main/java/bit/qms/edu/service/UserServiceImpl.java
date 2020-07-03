package bit.qms.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.qms.edu.model.UserModel;
import bit.qms.edu.request.UserRequest;
import bit.qms.edu.response.UserResponse;
import bit.qms.edu.spring.repo.UserRepository;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;

	
	/**
	 * Creates an user object and stores in database and returns an user response
	 * @param request
	 * @return
	 */
	@Transactional
	public UserResponse createUser(UserRequest request) {
		UserResponse response = new UserResponse(); // response which is given back to caller
		UserModel model = new UserModel(); // This is data model that represents a table row
		model.setFirstName(request.getFirstName());
		model.setLastName(request.getLastName());
		model.setEmail(request.getEmail());
		model.setContactNumber(request.getContactNumber());
		model.setExpertise(request.getExpertise());
		model.setPassword(request.getPassword());
		model.setRole(request.getRole());

		model = userRepository.save(model);

		response.setId(model.getUserId());
		response.setName(model.getFirstName());
		response.setEmailId(model.getEmail());
		return response;
	}
	
	public UserModel getUser(String email, String password) {
		return userRepository.getUser(email, password);
	}
}
