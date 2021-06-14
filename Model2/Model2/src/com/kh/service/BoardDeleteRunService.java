package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.BoardDao;

public class BoardDeleteRunService implements IService {
	
	private BoardDao boardDao= BoardDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 삭제처리
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		//System.out.println(b_no);
		boolean result = boardDao.deleteArticle(b_no);
		
		HttpSession session = request.getSession();
		session.setAttribute("resultDelete", result);
		return IService.REDIRECT + "/BoardList.do";
	}
}
