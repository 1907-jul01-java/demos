package com.revature.servletdemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HelloWorldServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String greeting = getServletContext().getInitParameter("greeting");
		HttpSession session = req.getSession(false);
		if (name == null) {
			if (session == null)
				name = getInitParameter("name");
			else
				name = (String) session.getAttribute("name");
		} else {
			session = req.getSession();
			session.setAttribute("name", name);
		}

		resp.getWriter().println(greeting + ", " + name);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
