package com.kh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		System.out.println("doget 실행");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		System.out.println("dopost 실행");
		String user_name = req.getParameter("user_name");
		System.out.println(user_name);
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy 실행");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init 실행");
	}
	
}
