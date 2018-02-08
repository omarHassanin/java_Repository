package org.spring.startup.Messages;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.spring.startup.users.UserController;
import org.spring.startup.users.UserModel;
import org.spring.startup.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MessagesController {
	
	
	
	@Autowired
	MessageService messageService   ; 
	@Autowired
	UserService userService ; 
	
	public  UserModel receiver ; 
	
	@RequestMapping(  method=RequestMethod.POST  ,  value="/mail")
   public String     send(HttpServletRequest request   , Model model  ) {
		
		
		
   String confirm = "Message sent successfully";	
		
  UserModel user = UserController.user ;
  
  String login_user_Email = user.getEmail();
  String login_user_name = user.getName();
  
	 
   String receiverEmail = request.getParameter("receiver");
   
   UserModel receiver  =  userService.getUser(receiverEmail);
   
   if( receiver==null ) {
	   model.addAttribute("WarningMessage", "please inter valid username ");
	   model.addAttribute("name", login_user_name);
	   
	   return "compose_mail";
	   
   }
   
   
   
   String content =request.getParameter("content");
   
   String subject =request.getParameter("subject");
   
   String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
   
   UserMessage message = new UserMessage(  login_user_Email  ,  content , subject  , receiver , timeStamp  );
   
   messageService.addMessage( message);
   
	model.addAttribute("confirm", confirm);
	model.addAttribute("name", login_user_name);
	
    return "compose_mail";
 	 
 }
	
	@RequestMapping(  method=RequestMethod.GET  ,  value="/message_view")
	public String viewMessage( Model model  ) {
		
		
		
	List<UserMessage> inboxMessages 	=  new ArrayList<>();
		
	inboxMessages = 	messageService.getUserMessages(UserController.email);
	
	UserModel user = UserController.user ;
	
	model.addAttribute("messages", inboxMessages);
	model.addAttribute("name", user.getName());
	
	return "message_view";
    
  	
	}
 
 
	

}
