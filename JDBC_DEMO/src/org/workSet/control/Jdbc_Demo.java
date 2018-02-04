package org.workSet.control;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.workSet.jdbc.*;
import org.workSet.model.*;

public class Jdbc_Demo {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		
	//	Triangle triangle = ctx.getBean("jdbc_DAO_Imple"   , Jdbc_DAO_Imple.class ).getTriangle(12);
		int number =   ctx.getBean("jdbc_DAO_Imple"   , Jdbc_DAO_Imple.class ).records_count();
		System.out.println(number);

	}

}
