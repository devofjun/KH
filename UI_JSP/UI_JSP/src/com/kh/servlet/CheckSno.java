package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.db.UIDao;

/**
 * Servlet implementation class CheckSno
 */
@WebServlet("/CheckSno")
public class CheckSno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 학번이 유효한지 확인하기 위한 비동기방식의 서블릿
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String sno = request.getParameter("SNO");
		UIDao dao = UIDao.getInstance();
		boolean result = dao.checkSNO(sno);
		
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}
