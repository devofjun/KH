package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		// hong/1234 로 저장 되 어 있다고 가정
		String result = "fail";
		if(user_id.equals("hong") && user_pw.equals("12345")) {
			result = "success";
		}
		//response.getWriter().print(result);
		PrintWriter out = response.getWriter(); // 출력스트림 얻어냄
		out.print(result);
	}

}
