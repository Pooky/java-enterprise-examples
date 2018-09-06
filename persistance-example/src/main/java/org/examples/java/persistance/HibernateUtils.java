package org.pooky.examples.java.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {

	private static EntityManager em;
	
	public static EntityManager getEntityManager() {
		
		if(em == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("LOCAL_TEST");
			em = factory.createEntityManager();
		}
		
		return em;
		
	}
	
}
