package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IStudentService;
import service.StudentDeleteRunService;
import service.StudentListService;
import service.StudentModifyFormService;
import service.StudentModifyRunService;
import service.StudentRegistFormService;
import service.StudentRegistRunService;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("*.kh")
public class StudentFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PREFIX = "/WEB-INF/views/";
	private static final String SUFFIX = ".jsp";

	private Map<String, IStudentService> commandMap = new HashMap<>();

	public StudentFrontController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		
		commandMap.put("StudentList.kh", new StudentListService());
		commandMap.put("StudentRegistForm.kh", new StudentRegistFormService());
		commandMap.put("StudentRegistRun.kh", new StudentRegistRunService());
		commandMap.put("StudentModifyForm.kh", new StudentModifyFormService());
		commandMap.put("StudentModifyRun.kh", new StudentModifyRunService());
		commandMap.put("StudentDeleteRun.kh", new StudentDeleteRunService());
	}

	public String getCommand(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String command = uri.substring(1);
		return command;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String command = getCommand(request);
		String page = "";
		IStudentService service = commandMap.get(command);
		System.out.println("controller_service: " + service);

		RequestDispatcher dispatcher = null;
		
		try {
			page = service.execute(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(page.startsWith(IStudentService.REDIRECT)) {
			String rePage = page.substring(IStudentService.REDIRECT.length());
			response.sendRedirect(rePage);
		} else {
			dispatcher = request.getRequestDispatcher(PREFIX+page+SUFFIX);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
