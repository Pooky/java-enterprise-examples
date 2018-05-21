package org.examples.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * Main runnable method, which will perform following operations:
 *    
 *    Create new instance of Weld (Dependency Injection library solution)
 *    Initialize Weld container
 *    Assign RunableApplication.class to Weld Container
 *    Run RunableApplication method
 * 
 * @see https://randling.wordpress.com/2011/08/15/cdi-in-java-se/
 */
public class Main {

	public static void main(String[] args) {

		Weld weld = new Weld();

		WeldContainer container = weld.initialize();

		RunableApplication application = container.instance().select(RunableApplication.class).get();

		application.run();

		weld.shutdown();

	}
}
