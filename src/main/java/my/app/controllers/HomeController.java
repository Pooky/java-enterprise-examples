package my.app.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 


@WebServlet(
		asyncSupported = false, 
		name = "HomeController",
		urlPatterns = {"/HomeController"}
)
public class HomeController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/home/result.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StringBuilder output = new StringBuilder("Anotation serverlet!");
		output.append("<br>: ");
		output.append(req.getParameter("myParam"));
		
		String errorMsg = null;
		
		Integer age = Integer.parseInt(req.getParameter("age"));
		if(age > 99) {
			errorMsg = "Age is not valid";
		}
		if(age < 0) {
			errorMsg = "Age can't be below zero";
		}
		
		req.setAttribute("errorMsg", errorMsg);
		req.setAttribute("show_result", true);
		req.getRequestDispatcher("/jsp/home/result.jsp").forward(req, resp);
		
	}

	
	
	
}