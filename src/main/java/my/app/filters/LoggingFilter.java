package my.app.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Filter for all requests
 *
 */

@WebFilter("/*")
public class LoggingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String url = null;
		String queryString = null;
		
		
		if (request instanceof HttpServletRequest) {
			
			url 		= ((HttpServletRequest) request).getRequestURL().toString();
			queryString = ((HttpServletRequest) request).getQueryString();
			
		}

		System.out.println("Incoming request : " + url);

		chain.doFilter(request, response);

	}

}
