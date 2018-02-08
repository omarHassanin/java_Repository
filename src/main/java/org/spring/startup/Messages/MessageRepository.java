package org.spring.startup.Messages;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MessageRepository  extends CrudRepository<UserMessage, String >  {
	
	public List<UserMessage>  findByReceiverUserEmail(String email);
	
	

}
