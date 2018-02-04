package spring.services;

import spring.aspects.loggable;
import spring.models.*;

public class ServiceShape {
	
	private Circile circile ; 
	
	private Triangle triangle ; 
	
	public Circile getCircile() {
		return circile;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	 
	public void setCircile(Circile circile) {
		this.circile = circile;
	}
	
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	

}
