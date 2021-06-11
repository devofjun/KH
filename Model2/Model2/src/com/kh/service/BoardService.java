package com.kh.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.BoardDao;
import com.kh.vo.BoardVo;

public class BoardService {
	private BoardDao boardDao = BoardDao.getInstance();
	
	public List<BoardVo> execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<BoardVo> list = boardDao.getBoardList();
		return list;
	}
	
}
