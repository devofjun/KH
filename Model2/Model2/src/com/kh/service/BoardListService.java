package com.kh.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.BoardDao;
import com.kh.vo.BoardVo;

public class BoardListService implements IService{
	private BoardDao boardDao = BoardDao.getInstance();
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<BoardVo> list = boardDao.getBoardList();
		request.setAttribute("list", list);
		return "board/BoardList";
	}
	
}
