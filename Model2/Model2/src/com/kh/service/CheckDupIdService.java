package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.MemberDao;

public class CheckDupIdService implements IService {
	
	private MemberDao memberDao = MemberDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String user_id = request.getParameter("user_id");
		boolean result = memberDao.checkDupId(user_id);
		request.setAttribute("data", result);
		return "data"; // data.jsp
	}

}
