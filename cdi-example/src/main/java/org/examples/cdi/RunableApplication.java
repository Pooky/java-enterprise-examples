package org.examples.cdi;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.examples.cdi.injected.classes.ObjectInterface;
import org.examples.cdi.injected.classes.ProductionObject;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
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

		logger.info("** Application with CDI initialized **");
		String message = injectedObject.getMessage();
		logger.info(message);

	}

	/**
	 * Main runnable method, which will perform following operations:
	 * 
	 * Create new instance of Weld (Dependency Injection library solution)
	 * Initialize Weld container 
	 * Assign RunableApplication.class to Weld Container
	 * Run RunableApplication method
	 * 
	 * @see https://randling.wordpress.com/2011/08/15/cdi-in-java-se/
	 */
	public static void main(String[] args) {

		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		RunableApplication application = container.instance().select(RunableApplication.class).get();
		application.run();
		weld.shutdown();

	}

}