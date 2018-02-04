package spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogingAspect {
	
/*	
	@AfterReturning(pointcut="args(*) "  , returning = "Output")
	public void loggingAdvice(  String Output) {
		System.out.println("calling methods how is taken strings parameters the string is and output is " + Output);
		
       }

	@AfterThrowing(pointcut = "args(name)"  ,  throwing ="ex" )
	public void loggingFinallyAdvice(String name , RuntimeException ex  ) {
		System.out.println("exception is   " + ex);
		
       }
	*/
	
	@Around("@annotation(spring.aspects.loggable)")
	public void   more_Control_Advice(ProceedingJoinPoint proceedingJoinPoint ) throws Throwable {
		
		
		try {
			
			System.out.println("  before excuation   " );
			
			proceedingJoinPoint.proceed();
			
			System.out.println("AfterReturning  " ) ;	
			
			
			
		} catch (Throwable e) {
			
			System.out.println("Afterthrowninging  " ) ;	

		}

		System.out.println("After finally   " ) ;	

		
	}
	
	
	
	
	
	
	
	/*@Before("allGetters()")
	public void secondAdvise() {
		System.out.println("releasing  the logging version 2 ");
	}*/
	
	
	
	
	
	
	
	@Pointcut("execution( * get*())")
	public void allGetters() {}
		
	
	
	@Pointcut("within(spring.models.Circile)")
	public void allCircile_Getters() {}
		

		

	
	

}
