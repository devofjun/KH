package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.BoardDao;
import com.kh.vo.BoardVo;

public class BoardModifyRunService implements IBoardService {

	private BoardDao dao = BoardDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");
		String m_id = request.getParameter("m_id");
		System.out.println(b_title + b_content + m_id);
		
		BoardVo vo = new BoardVo(b_no, b_title, b_content, null, m_id, 0, 0, 0, 0, null);
		
		boolean result = dao.updateArticle(vo);
		
		HttpSession session = request.getSession();
		session.setAttribute("resultModify", result);
		
		return IBoardService.REDIRECT + "/BoardContent.do?b_no="+b_no;
	}

}
