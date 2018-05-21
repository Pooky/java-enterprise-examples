package org.examples.withoutCDI;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.examples.cdi.injected.classes.ObjectInterface;
import org.examples.cdi.injected.classes.ProductionObject;
import org.examples.cdi.injected.classes.MockObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunableApplication {

	private static Logger logger = LoggerFactory.getLogger(RunableApplication.class);

	private MockObject injectedBean;

	/**
	 * Constructor of the class
	 */
	public RunableApplication() {
		
		// We creating new instance of the bean locally
		this.injectedBean = new MockObject(); 
		
	}
	
	public void run() {
		
		logger.info("application initialized");
		String message = injectedBean.getMessage();
		logger.info(message);

	}

}