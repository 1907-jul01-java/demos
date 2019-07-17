package com.revature.servletdemo;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Warning, incoming request");
		if (request.getParameter("name") != null)
			if (request.getParameter("name").equalsIgnoreCase("Tony"));
				System.out.println("Tony incoming");

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
}
