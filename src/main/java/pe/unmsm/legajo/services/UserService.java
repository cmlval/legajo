package pe.unmsm.legajo.services;

import pe.unmsm.legajo.domain.User;

public interface UserService extends CRUDService<User> {
	
	User findByUserName(String userName);

}
