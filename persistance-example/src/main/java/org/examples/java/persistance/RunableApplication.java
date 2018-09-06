package org.pooky.examples.java.persistance;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.pooky.examples.java.persistance.entity.User;
import org.pooky.examples.java.persistance.enums.UserType;

public class RunableApplication {

	private EntityManager em;
	
	public RunableApplication() {
		em = HibernateUtils.getEntityManager();
	}
	
	/**
	 * Run method
	 */
	public void run() {
		
		writeOutUsers();
		
		insertNewUser();
		insertNewUser();
		
		writeOutUsers();

		em.close();
		
		
	}
	private void writeOutUsers() {

		Query query = em.createQuery("From User");
		
		List result = query.getResultList();
		
		for(Object object : result) {
			User user = (User)object;
			System.out.println(user.toString());
		}
		
		
		
	}

	private void insertNewUser() {
		
		// Create new user instance
		User user = new User();
		user.setEmail("email@email.com");
		user.setName("User name");
		user.setUserType(UserType.Admin);
		
		// Begin transaction
		em.getTransaction().begin();
		// Save user to DB
		em.persist(user);
		
		// Commit transaction
		em.getTransaction().commit();
		
	}

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {

		RunableApplication application = new RunableApplication();
		application.run();


	}

}