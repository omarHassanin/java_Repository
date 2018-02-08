package org.spring.startup.Messages;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import org.spring.startup.users.UserModel;
import org.springframework.stereotype.Component;

@Component


@Entity
public class UserMessage {
	
	@Id
	 private String sender ;
	 private String messageContent ; 
	 private String messageSubject  ; 
     private String messageDate ; 
	 
    @ManyToOne
	private UserModel receiverUser ; 
	 
	  public UserMessage() {}
	  
	  public UserMessage( String sender  , String content , String subject   , UserModel user  , String date  ) {
		  
		  
		  this.sender = sender  ; 
		  this.messageContent = content ; 
		  this.messageSubject = subject ; 
		  this.receiverUser = user ; 
		  this.messageDate = date;
	  }

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}
	  
	  
	
	 public UserModel getReciverUser() {
		return receiverUser;
	}

	public void setReciverUser(UserModel reciverUser) {
		this.receiverUser = reciverUser;
	}
	
	 public String getMessageSubject() {
		return messageSubject;
	}

	public void setMessageSubject(String messageSubject) {
		this.messageSubject = messageSubject;
	}



}
