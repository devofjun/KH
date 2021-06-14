package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.BoardDao;
import com.kh.vo.BoardVo;

public class BoardModifyRunService implements IService {

	private BoardDao boardDao = BoardDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 수정처리
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");
		String m_id = request.getParameter("m_id");
		
		//BoardVo boardVo = new BoardVo(b_no, b_title, b_content, null, m_id, null, null, null, null, null);
		BoardVo boardVo = new BoardVo();
		boardVo.setB_no(b_no);
		boardVo.setB_title(b_title);
		boardVo.setB_content(b_content);
		boardVo.setM_id(m_id);
		boolean result = boardDao.updateArticle(boardVo);
		return IService.REDIRECT + "/BoardContent.do?b_no=" + b_no;
	}

}
