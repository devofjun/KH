package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.BoardDao;

public class BoardDeleteRunService implements IBoardService {
	
	private BoardDao dao = BoardDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		boolean resultDelete = dao.deleteArticle(b_no);
		HttpSession session = request.getSession();
		session.setAttribute("resultDelete", resultDelete);
		return IBoardService.REDIRECT + "/BoardList.do";
	}

}
