package org.examples.cdi;

import org.examples.cdi.injected.classes.MockObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunableApplicationWithoutCDI {

	private static Logger logger = LoggerFactory.getLogger(RunableApplicationWithoutCDI.class);

	private MockObject injectedBean;

	/**
	 * Constructor of the class
	 */
	public RunableApplicationWithoutCDI() {
		
		// We creating new instance of the bean locally
		this.injectedBean = new MockObject(); 
		
	}
	
	public void run() {
		
		logger.info("** Application without CDI initialized **");
		String message = injectedBean.getMessage();
		logger.info(message);

	}

	/**
	 * Main method to run the class
	 */
	public static void main(String[] args) {
		
		RunableApplicationWithoutCDI application = new RunableApplicationWithoutCDI();
		application.run();
	}
}