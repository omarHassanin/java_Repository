package io.javabrains;

public class Gretting {
	
	
	
	
	public static void main(String[] args) {
		
		
	testing testLambda =  () -> System.out.println("hello lambdaaaaaaaa ");
	testing innertest = new testing() {
		
		@Override
		public void perform() {
			System.out.println("hello inner class  ");
			
		}
	};
	
	testLambda.perform();
    greetingMessage(testLambda);
    greetingMessage(innertest);

	}

	
	public static void greetingMessage (testing test ) {
		
		test.perform();
	
	}
	
	
}

  interface testing {

	 public void   perform  ();
	}
	  
