package com.kh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.service.BoardService;
import com.kh.vo.BoardVo;

/**
 * Servlet implementation class BoardController
 */
// 뒤에 .do가 달리면 요청을 받겠다는것
@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = getCommand(request);
		// 글목록 - BoardList - > 글목록 페이지로 포워드
		// 글쓰기 폼 - BoardWriteForm -> 글쓰기 폼으로 포워드
		// 글쓰기 처리 - BoardWriteRun -> 글목록으로 리다이렉트
		RequestDispatcher dispatcher = null;
		switch(command) {
		case "BoardList":
			BoardService boardService = new BoardService();
			try {
				List<BoardVo> list = boardService.execute(request, response);
				request.setAttribute("list", list);
			} catch(Exception e) {
				e.printStackTrace();
			}
			// 웹브라우저에서는 "/WEB-INF" 로 접근 할 수 없지만 현재 Servlet에서 접근 가능하다.
			dispatcher = request.getRequestDispatcher("/WEB-INF/views/board/BoardList.jsp");
			dispatcher.forward(request, response);
			break;
		case "BoardWriteForm":
			dispatcher = request.getRequestDispatcher("/WEB-INF/views/board/BoardWriteForm.jsp");
			dispatcher.forward(request, response);
			
			break;
		case "BoardWriteRun":
			// 글쓰기 처리를 했다 치고...
			response.sendRedirect("/BoardList.do");
			break;
		}
	}
	
	private String getCommand(HttpServletRequest request) {
		String uri = request.getRequestURI();
		int dotIndex = uri.lastIndexOf("."); 
		String command = uri.substring(1, dotIndex);
		return command;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
