package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.MemberDao;
import com.kh.vo.MemberVo;

public class MemberJoinRunService implements IService {
	
	private MemberDao memberDao = MemberDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");
		System.out.println("MemberJoinRunService, execute(), user_id:" + user_id);
		System.out.println("MemberJoinRunService, execute(), user_pw:" + user_pw);
		System.out.println("MemberJoinRunService, execute(), user_name:" + user_name);
		MemberVo memberVo = new MemberVo(user_id, user_pw, user_name);
		boolean result = memberDao.insertMember(memberVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("resultMemberJoin", result);
		return IService.REDIRECT + "MemberLoginForm.do";
	}

}
