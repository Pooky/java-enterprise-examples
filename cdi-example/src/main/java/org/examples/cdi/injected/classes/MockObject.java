package org.examples.cdi.injected.classes;

/**
 * Mock Object
 * For testing or other purposes
 */
public class MockObject implements ObjectInterface {

	public String getMessage() {
		
		return "Hello from " + this.getClass().getSimpleName();
	}
	
	
}
