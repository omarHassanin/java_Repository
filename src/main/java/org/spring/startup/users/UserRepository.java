package org.spring.startup.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository  extends CrudRepository<UserModel, String> {
	
	
	

}
