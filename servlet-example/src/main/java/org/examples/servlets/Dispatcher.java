package org.examples.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Dispatcher which will process every request, which is not mapped to anyone
 * Basically this is default controller - 404 Page not FOUND!
 * @see /src/main/webapp/WEB-INF/web.xml
 */
public class Dispatcher extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String queryString = ((HttpServletRequest) req).getRequestURI();
		
		resp.getWriter().write("Dispatcher : " + queryString);
		
	}

}
