package org.spring.startup.Messages;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageService {
	
	@Autowired
	MessageRepository repository ;

	public void addMessage(UserMessage message) {
	  
	
     repository.save(message);
	
			} 
	
	public List<UserMessage> getUserMessages(String email){
		
	 List<UserMessage> messages = new ArrayList<>();
		
	  repository.findByReceiverUserEmail(email)
	  .forEach(messages::add);
	  
	  return messages ; 
		  
		  
	  }
	
  
	
    		
		
	}
	
	


