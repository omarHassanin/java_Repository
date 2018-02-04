package spring.conrol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.services.ServiceShape;

public class Controller {

	public static void main(String[] args) {

		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ServiceShape service = ctx.getBean("ServiceShape" , spring.services.ServiceShape.class );
		
	 	service.getCircile().setName("omooooo");
	//	System.out.println(service.getCircile().getName());  
		
	}

}
