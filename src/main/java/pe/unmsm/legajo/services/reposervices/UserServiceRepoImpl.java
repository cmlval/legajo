package pe.unmsm.legajo.services.reposervices;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unmsm.legajo.domain.User;
import pe.unmsm.legajo.repositories.UserRepository;
import pe.unmsm.legajo.services.UserService;

@Service
public class UserServiceRepoImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<?> listAll() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	@Override
	public User getById(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Override
	public User saveOrUpdate(User domainObject) {
		// TODO Auto-generated method stub
		return userRepository.save(domainObject);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		User user = userRepository.findOne(id);
		userRepository.delete(user);
	}

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(userName);
	}

	

}
