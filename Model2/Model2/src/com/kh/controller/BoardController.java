package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.service.BoardContentService;
import com.kh.service.BoardDeleteRunService;
import com.kh.service.BoardListService;
import com.kh.service.BoardModifyFormService;
import com.kh.service.BoardModifyRunService;
import com.kh.service.BoardReplyFormService;
import com.kh.service.BoardReplyRunService;
import com.kh.service.BoardWriteFormService;
import com.kh.service.BoardWriteRunService;
import com.kh.service.CheckDupIdService;
import com.kh.service.CommentListService;
import com.kh.service.IService;
import com.kh.service.MemberJoinFormService;
import com.kh.service.MemberJoinRunService;
import com.kh.service.MemberLoginFormService;
import com.kh.service.MemberLoginRunService;
import com.kh.service.MemberLogoutService;

/**
 * Servlet implementation class BoardController
 */
// 뒤에 .do가 달리면 요청을 받겠다는것
@WebServlet({"*.do", "*.mem"})
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PREFIX = "/WEB-INF/views/";
	private static final String SUFFIX = ".jsp";
	private Map<String, IService> commandMap = new HashMap<>();
    public BoardController() {
        super();
    }

    @Override
    public void init() throws ServletException { // 서블릿이 처음 실행될때 한번만 실행되는 메소드
    	super.init();
    	commandMap.put("BoardList.do",new BoardListService());
    	commandMap.put("BoardWriteForm.mem", new BoardWriteFormService());
    	commandMap.put("BoardWriteRun.mem", new BoardWriteRunService());
    	commandMap.put("BoardContent.mem", new BoardContentService());
    	commandMap.put("BoardModifyForm.mem", new BoardModifyFormService());
    	commandMap.put("BoardDeleteRun.mem", new BoardDeleteRunService());
    	commandMap.put("BoardModifyRun.mem", new BoardModifyRunService());
    	commandMap.put("BoardReplyForm.mem", new BoardReplyFormService());
    	commandMap.put("BoardReplyRun.mem", new BoardReplyRunService());
    	commandMap.put("MemberJoinForm.do", new MemberJoinFormService());
    	commandMap.put("MemberJoinRun.do", new MemberJoinRunService());
    	commandMap.put("MemberLoginForm.do", new MemberLoginFormService());
    	commandMap.put("MemberLoginRun.do", new MemberLoginRunService());
    	commandMap.put("MemberLogout.mem", new MemberLogoutService());
    	commandMap.put("CheckDupId.do", new CheckDupIdService());
    	commandMap.put("CommentList.mem", new CommentListService());
    	
    	System.out.println(commandMap);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = getCommand(request);
		IService service = commandMap.get(command);
		System.out.println("Service:" + service);
		// 글목록 - BoardList - > 글목록 페이지로 포워드
		// 글쓰기 폼 - BoardWriteForm -> 글쓰기 폼으로 포워드
		// 글쓰기 처리 - BoardWriteRun -> 글목록으로 리다이렉트
		RequestDispatcher dispatcher = null;
		
		String page = "";
		
		try {
			page = service.execute(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(page.startsWith(IService.REDIRECT)) {
			String rPage = page.substring(IService.REDIRECT.length());
			response.sendRedirect(rPage);
		} else if(page.startsWith(IService.DATA)) {
			// data를 담기 전에 인코딩을 해줘야한다.
			response.setContentType("text/plain;charset=UTF-8");
			Object data = request.getAttribute("data");
			PrintWriter out = response.getWriter();
			//response.setCharacterEncoding("utf-8");
			out.print(data.toString());
		} else {
			// 웹브라우저에서는 "/WEB-INF" 로 접근 할 수 없지만 현재 Servlet에서 접근 가능하다.
			dispatcher = request.getRequestDispatcher(PREFIX+page+SUFFIX);
			dispatcher.forward(request, response);
		}
	}
	
	private String getCommand(HttpServletRequest request) {
		String uri = request.getRequestURI();
		//int dotIndex = uri.lastIndexOf("."); 
		//String command = uri.substring(1, dotIndex);
		String command = uri.substring(1);
		return command;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
