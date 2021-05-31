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
@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 요청 데이터에 대한 한글처리
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		// 보낼려고 하는 데이터를 미리 알려줌
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String strLogin = "실패";
		if(user_id.equals("hong") && user_pw.equals("1234")) {
			strLogin = "성공";
		}
		
		// Servlet의 단점 -> HTML 코드 생성이 너저분하다.
		String html = "<!doctype html>";
		html += "<html>";
		html += "<head>";
		html += "<meta charset='utf-8'>";
		html += "<title></title>";
		html += "</head>";
		html += "<body>";
		html += "<h1>로그인 "+ strLogin +"</h1>";
		html += "</body>";
		html += "</html>";
		
		out.print(html);
	}

}
