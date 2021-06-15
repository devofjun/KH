package com.kh.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.BoardDao;
import com.kh.vo.BoardVo;

public class BoardListService implements IBoardService{
	
	private BoardDao dao = BoardDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<BoardVo> list = dao.getBoardList();
		request.setAttribute("list", list);
		return "board/BoardList";
	}

}
