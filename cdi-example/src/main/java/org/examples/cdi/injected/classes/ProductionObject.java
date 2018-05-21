package org.examples.cdi.injected.classes;


/**
 * Production Object
 * 
 * For real production purpose 
 */
public class ProductionObject implements ObjectInterface{
	
	public String getMessage() {
		
		return "Hello from " + this.getClass().getSimpleName();
		
	}
	
}