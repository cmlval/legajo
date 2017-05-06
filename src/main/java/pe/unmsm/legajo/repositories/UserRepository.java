package pe.unmsm.legajo.repositories;

import org.springframework.data.repository.CrudRepository;

import pe.unmsm.legajo.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByUsername(String username);

}
