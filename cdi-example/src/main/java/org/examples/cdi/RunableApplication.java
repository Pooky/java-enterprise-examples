package org.examples.cdi;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.examples.cdi.injected.classes.ObjectInterface;
import org.examples.cdi.injected.classes.ProductionObject;
import org.examples.cdi.injected.classes.MockObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @see http://docs.jboss.org/weld/reference/latest-master/en-US/html_single/
 */
public class RunableApplication {

	private static Logger logger = LoggerFactory.getLogger(RunableApplication.class);

	@Inject
	private MockObject injectedObject;

	public void run() {
		
		logger.info("application initialized");
		String message = injectedObject.getMessage();
		logger.info(message);

	}

}