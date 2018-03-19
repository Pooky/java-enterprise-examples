package org.examples.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class Listener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("============== WebApp Initialized ================");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("WebApp Destroyed");
	}

}
