package com.kh.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.service.IStudentService;
import com.kh.service.StudentDeleteService;
import com.kh.service.StudentListService;
import com.kh.service.StudentModifyFormService;
import com.kh.service.StudentModifyRunService;
import com.kh.service.StudentRegistFormService;
import com.kh.service.StudentRegistRunService;

/**
 * Servlet implementation class StudentFrontController
 */
@WebServlet("*.do")
public class StudentFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PREFIX = "/WEB-INF/views/";
	private final String SUFFIX = ".jsp";
	
	
	private Map<String, IStudentService> commandMap = new HashMap<>();

	public StudentFrontController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		commandMap.put("student_list.do", new StudentListService());
		commandMap.put("student_regist_form.do", new StudentRegistFormService());
		commandMap.put("student_regist_run.do", new StudentRegistRunService());
		commandMap.put("student_modify_form.do", new StudentModifyFormService());
		commandMap.put("student_modify_run.do", new StudentModifyRunService());
		commandMap.put("student_delete.do", new StudentDeleteService());
		
	}
	
	private String getCommand(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String command = uri.substring(1);
		return command;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String command = getCommand(request);
			IStudentService service = commandMap.get(command);
			String page = service.execute(request, response);
			
			if(page.startsWith(IStudentService.IREDIRECT)) {
				String rPage = page.substring(IStudentService.IREDIRECT.length());
				response.sendRedirect(rPage);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(PREFIX+page+SUFFIX);
				dispatcher.forward(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
