package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.db.StudentDao;

/**
 * Servlet implementation class StNumCheckServlet
 */
@WebServlet("/checkNum")
public class StNumCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int st_num = Integer.parseInt(request.getParameter("st_num"));
		StudentDao dao = StudentDao.getInstance();
		
		boolean result = dao.checkStNum(st_num);
		PrintWriter out = response.getWriter();
		out.print(result);
	}
}