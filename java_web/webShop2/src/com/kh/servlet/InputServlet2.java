package com.kh.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet2
 */
@WebServlet("/input2")
public class InputServlet2 extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> names =  request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			//System.out.println(name);
			String val = request.getParameter(name);
			System.out.println(name + ":" + val);
			
		}
	}

}
