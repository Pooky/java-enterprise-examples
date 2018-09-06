package org.examples.java.persistance;

import javax.inject.Inject;
import org.examples.java.persistance.entity.User;
import org.examples.java.persistance.enums.UserType;
import org.examples.java.service.IUserService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * Main method to run application
 * @author martin.klima
 * @url https://github.com/Pooky/java-enterprise-examples
 *  
 */
public class RunableApplication {
	
	@Inject
	private IUserService service;

	/**
	 * Run method
	 */
	public void run() {

		System.out.println("--- Starting application -----");
		
		// Get Users and write them out (
		System.out.println(service.getUsers().toString());

		// Save two users
		service.saveUser(getNewUser("user1@mail.com", "Max", UserType.ADMIN));
		service.saveUser(getNewUser("user2@mail.com", "Tomas", UserType.REGULAR));

		
		// Print new list of users
		service.getUsers().stream().forEach(e -> System.out.println(e));

		System.out.println("--- All done! -----");
				
	}

	/**
	 * Insert new user and persist it
	 * @return 
	 */
	private User getNewUser(String email, String name, UserType type) {

		// Create new user instance
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setUserType(type);
		
		return user;
		
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