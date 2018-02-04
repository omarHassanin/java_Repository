package spring.models;

import spring.aspects.loggable;

public class Circile {
	
 private 
	
	public String getName() {
		return name;
	}
	
	
	public public Circile() {
		// TODO Auto-generated constructor stub
	}
	
	@loggable
  public void setName(String name) {
	this.name = name;
	System.out.println(name);
 	throw (new RuntimeException() );
}

}
