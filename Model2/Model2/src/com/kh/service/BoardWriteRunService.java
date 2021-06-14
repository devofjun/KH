package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.BoardDao;
import com.kh.vo.BoardVo;

public class BoardWriteRunService implements IService{
	
	private BoardDao boardDao = BoardDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 글쓰기 처리
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");
		String m_id = request.getParameter("m_id");
		BoardVo boardVo = new BoardVo();
		boardVo.setB_title(b_title);
		boardVo.setB_content(b_content);
		boardVo.setM_id(m_id);
		boolean result = boardDao.insertArticle(boardVo);
		
		// 세션은 서버쪽에 저장되는 정보이다.
		HttpSession session = request.getSession();
		session.setAttribute("resultWrite", result);
		
		return IService.REDIRECT + "/BoardList.do";
	}

}
