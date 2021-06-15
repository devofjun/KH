package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.BoardDao;
import com.kh.vo.BoardVo;

public class BoardReplyRunService implements IService {
	
	private BoardDao boardDao = BoardDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 답글의 필요한 정보
		int re_group = Integer.parseInt(request.getParameter("re_group"));
		int re_seq = Integer.parseInt(request.getParameter("re_seq"));
		int re_level = Integer.parseInt(request.getParameter("re_level"));
		// 담길 내용
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");
		String m_id = request.getParameter("m_id");
		// 내용 담기
		BoardVo boardVo = new BoardVo(0, b_title, b_content, null, m_id, 0, re_group, re_seq, re_level, null);
		// dao를 통해 DB에 데이터 저장하기
		boolean result = boardDao.insertReply(boardVo);
		HttpSession session = request.getSession();
		session.setAttribute("resultReply", result);
		
		return IService.REDIRECT + "/BoardList.do";
	}

}
