package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.BoardDao;
import com.kh.vo.BoardVo;

public class BoardContentService implements IBoardService {

	private BoardDao dao = BoardDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		BoardVo vo = dao.selectByBno(b_no);
		request.setAttribute("vo", vo);
		return "board/BoardContent";
	}

}
