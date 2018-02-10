package org.spring.startup.users;






import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.spring.startup.Messages.MessageService;
import org.spring.startup.Messages.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {
	
	
	public  static  String email ;
	public  static  String name ; 
	
    public  static  UserModel user ; 

	@Autowired
	public MessageService messageService ;
	
	
	@Autowired
	 public  UserService userService ; 
	

	@RequestMapping("/")	
	public String     getLogin() {  return "login" ;       }
	
	
	
	@RequestMapping("/signup")
	  public String signup() {	return  "registeration" ;   }	
	
	
	
	
	@RequestMapping(  method=RequestMethod.GET ,  value="/mail")
	  public String sendingMail(Model model ) {	
		
		model.addAttribute("name",user.getName());
		
		
		return  "compose_mail" ;   }	
	
 
	
	
	@RequestMapping("/logout")	
	public String     logout() {
	  
	  name = null ; 
	  return "login" ;   
 
    }
	
	
	
	
	
	
	@RequestMapping( method=RequestMethod.POST, value= "/home")
	public String login( HttpServletRequest request   , Model model ) {
		
		
	List<UserMessage> inboxMessages 	=  new ArrayList<>();

    email = request.getParameter("email");
    String password = request.getParameter("Password");
    
    
    user  =   userService.validate( email );
    
   if(user==null ) {  return  "login" ;   }
   else if (password.equals(user.getPassword())==false) {
	   
	   model.addAttribute("CashedUserName", user.getName());
	   model.addAttribute("warningMessage","Invalid Password" );
	   
	    return  "login" ;
	   
	   
   }else {
    	
        model.addAttribute("name", user.getName());
        
        
        inboxMessages =  messageService.getUserMessages(email);
        
        int  NumberOFMessages = inboxMessages.size();
        boolean  check = inboxMessages.isEmpty();
        
         model.addAttribute("messages", inboxMessages);
         model.addAttribute("messagesNumber", NumberOFMessages);
         if(check==false) {
         model.addAttribute("check", "you have one mail");
         }
        
    	return  "profile" ;
    }
    
  
   

	}
	
	
	
	@RequestMapping( method = RequestMethod.POST  , value = "/confirmationPage")
   public String  signup( HttpServletRequest request   ) {
		
		 name = request.getParameter("Name"); 
		
		
		 email = request.getParameter("Email");
		
		
		String password = request.getParameter("Password");
		
		String phone = request.getParameter("Phone");
	   
	   UserModel user = new UserModel(name, email, phone, password);
	   userService.signup(user);
	   


	   
	   return "/registConfirmation";
	   
   } 	
	
	
	

}
