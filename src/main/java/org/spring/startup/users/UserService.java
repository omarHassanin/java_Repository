package org.spring.startup.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository ;

	public UserModel validate(String email) {
		
	UserModel user =  repository.findOne(email) ;
   
	
  return user ;
		
	}
	
	
	public UserModel getUser(String email) {
		
		UserModel user =  repository.findOne(email) ;

		
	  return user ;
			
		}
	
	

	public void signup(UserModel user) {
		repository.save(user);
		
	} 
	

	
	
	
	
	
	
}
