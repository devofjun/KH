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
		// name="xxx" 에 대해서
		// request.getParameter("xxx");
		Enumeration<String> names = request.getParameterNames();
		// -> 이름들을 열거형 names에 저장
		while(names.hasMoreElements()) {
			// 읽어낼 요소(name)가 있는지 (없으면 중단)
			// names에서 다음 요소 얻어내기
			String name = names.nextElement();
			// 얻어낸 name으로 넘어온 값 저장
			String val = request.getParameter(name);
			System.out.println(name + ":" + val);
		}
	}

}
