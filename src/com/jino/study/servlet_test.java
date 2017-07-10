package com.jino.study;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet_test extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head><title>Hello Servlet</title></head>");
		out.println("Hello Servlet!");
		out.println("<body>");
		out.println("</html>");
		out.close();
	}
}
