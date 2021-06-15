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

import com.kh.service.BoardContentService;
import com.kh.service.BoardListService;
import com.kh.service.BoardWriteFormService;
import com.kh.service.BoardWriteRunService;
import com.kh.service.IBoardService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PREFIX = "/WEB-INF/views/";
	private static final String SUFFIX = ".jsp";
	private Map<String, IBoardService> commandMap = new HashMap<>();

	public BoardController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		commandMap.put("BoardList", new BoardListService());
		commandMap.put("BoardWriteForm", new BoardWriteFormService());
		commandMap.put("BoardWriteRun", new BoardWriteRunService());
		commandMap.put("BoardContent", new BoardContentService());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 해당 요청에 매핑된 서비스 가져옴
		IBoardService service = commandMap.get(getCommand(request));
		
		// 서비스가 돌려주는 경로
		String path = "";
		// 포워딩을 하기 위한 변수
		RequestDispatcher dispatcher = null;
		try {
			path = service.execute(request, response);
			// 해당 서비스의 결과를 돌려준다.
			if (path.startsWith(IBoardService.REDIRECT)) { // 리다이렉트
				String rPage = path.substring(IBoardService.REDIRECT.length());
				response.sendRedirect(rPage);
			} else { // 포워드
				dispatcher = request.getRequestDispatcher(PREFIX + path + SUFFIX);
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	// 요청 문자열 자르기
	private String getCommand(HttpServletRequest request) {
		String uri = request.getRequestURI();
		int dotIndex = uri.lastIndexOf(".");
		String command = uri.substring(1, dotIndex);
		//System.out.println(command);
		return command;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
