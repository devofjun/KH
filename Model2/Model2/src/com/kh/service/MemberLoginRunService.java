package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.MemberDao;
import com.kh.vo.MemberVo;

public class MemberLoginRunService implements IService {
	
	private MemberDao memberDao = MemberDao.getInstance(); 
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		HttpSession session = request.getSession();
		String page = null;
		
		MemberVo memberVo = memberDao.login(user_id, user_pw);
		if(memberVo != null) { // 로그인 성공했다면 list로 돌아간다.
			session.setAttribute("memberVo", memberVo);
			session.setAttribute("resultLogin", true);
			page = IService.REDIRECT + "/BoardList.do";
		} else { // 로그인 실패했다면 
			session.setAttribute("resultLogin", false);
			page = IService.REDIRECT + "/MemberLoginForm.do";
		}
		
		return page;
	}

}
