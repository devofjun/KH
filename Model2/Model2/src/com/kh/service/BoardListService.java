package com.kh.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.BoardDao;
import com.kh.vo.BoardVo;
import com.kh.vo.PagingDto;

public class BoardListService implements IService{
	private BoardDao boardDao = BoardDao.getInstance();
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		
		int page = 1;
		String strPage = request.getParameter("page");
		if(strPage != null) {
			page = Integer.parseInt(strPage);
		}
		
		int perPage = 10;
		String strPerPage = request.getParameter("perPage");
		if(strPerPage != null) {
			perPage = Integer.parseInt(strPerPage);
		}
		
		PagingDto pagingDto = new PagingDto(page, boardDao.getCount(searchType, keyword), perPage, searchType, keyword);
		System.out.println("pagingDto: " + pagingDto);
		
		List<BoardVo> list = boardDao.getBoardList(pagingDto);
		request.setAttribute("pagingDto", pagingDto);
		request.setAttribute("list", list);
		return "board/BoardList";
	}
	
}
	