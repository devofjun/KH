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
		// 웹브라우저에서 전송된 데이터의 인코딩을 설정합니다.
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		//System.out.println(user_id + ", " + user_pw);
		// 응답할 데이터 종류가 HTML임을 설정합니다. utf-8 설정해주지 않으면 한글 깨짐
		response.setContentType("text/html;charset=utf-8");
		// 출력스트림 PrintWriter 객체를 받아옵니다.
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
