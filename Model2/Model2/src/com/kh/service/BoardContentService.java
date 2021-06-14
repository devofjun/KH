package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.BoardDao;
import com.kh.vo.BoardVo;

public class BoardContentService implements IService {
	
	private BoardDao boardDao = BoardDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 해당 글 가져오기
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		BoardVo boardVo = boardDao.selectByBno(b_no);
		request.setAttribute("boardVo", boardVo);
		return "board/BoardContent";
	}

}
