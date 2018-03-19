package org.examples.servlets.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HomeController 
 * 
 */
@WebServlet(asyncSupported = false, name = "HomeController", urlPatterns = { "/HomeController" })
public class HomeController extends HttpServlet {

	/**
	 * Method which will consume GET requests
	 * 
	 * This method will return "src/main/webapp/jsp/home/result.jsp/" page
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/home/result.jsp").forward(req, resp);
	}
	
	/**
	 * Method which will consume POST requests
	 * There is also simple example, how you can manipule request and response parameters 
	 * 
	 * @param GET myParam
	 * @param GET age
	 * 
	 **/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		
		StringBuilder output = new StringBuilder("Mapping is done by annotation!");
		
		output.append("<br>: ");
		output.append(req.getParameter("myParam"));

		String errorMsg = null;

		
		Integer age = Integer.parseInt(req.getParameter("age"));
		if (age > 99) {
			errorMsg = "Age is not valid";
		}
		if (age < 0) {
			errorMsg = "Age can't be below zero";
		}

		req.setAttribute("errorMsg", errorMsg);
		req.setAttribute("show_result", true);
		
		req.getRequestDispatcher("/jsp/home/result.jsp").forward(req, resp);

	}

}