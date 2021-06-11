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

import com.kh.service.BoardListService;
import com.kh.service.BoardWriteFormService;
import com.kh.service.BoardWriteRunService;
import com.kh.service.IService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PREFIX = "/WEB-INF/views/";
	private static final String SUFFiX = ".jsp";
	private Map<String, IService> commandMap = new HashMap<String, IService>(); 

    public BoardController() {super();}
    @Override
    public void init() throws ServletException {
    	super.init();
    	commandMap.put("BoardList", new BoardListService());
    	commandMap.put("BoardWriteForm", new BoardWriteFormService());
    	commandMap.put("BoardWriteRun", new BoardWriteRunService());
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = getCommand(request);
		IService service = commandMap.get(command);
		String page = "";
		try {
			page = service.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(page);
		if(page.startsWith(IService.REDIRECT)) {
			String rPage = page.substring(IService.REDIRECT.length());
			response.sendRedirect(rPage);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(PREFIX + page + SUFFiX);
			dispatcher.forward(request, response);
		}
	}
	private String getCommand(HttpServletRequest request) {
		String uri = request.getRequestURI();
		int dotIndex = uri.lastIndexOf(".");
		String command = uri.substring(1, dotIndex);
		System.out.println("substring: "+command);
		return command;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
