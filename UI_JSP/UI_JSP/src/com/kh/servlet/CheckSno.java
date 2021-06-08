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
		
		String result;
		String sno = request.getParameter("sno");
		
		String trimError = "학번을 입력해주세요.";
		String replaceError = "학번에 공백은 넣을 수 없습니다.";
		String lengthError = "학번은 8자리 숫자를 입력 받습니다.";
		//System.out.println(sno.trim());
		if(sno.trim().equals("")) {
			result=trimError;
		} else if(sno.replace(" ", "").length() != sno.length()) {
			result=replaceError;
		} else if(sno.length() != 8) {
			result=lengthError;
		} else {
			UIDao dao = UIDao.getInstance();
			result = String.valueOf(dao.checkSNO(sno));
		}
		//System.out.println(result);
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}
