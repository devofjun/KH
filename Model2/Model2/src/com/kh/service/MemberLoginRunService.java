package com.kh.service;

import javax.servlet.http.Cookie;
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
		String saveId = request.getParameter("saveId");
		HttpSession session = request.getSession();
		String page = null;
		
		MemberVo memberVo = memberDao.login(user_id, user_pw);
		if(memberVo != null) { // 로그인 성공했다면 list로 돌아간다.
			if(saveId != null && saveId.equals("true")) { // 아이디 저장에 체크했다면 쿠키 생성
				Cookie cookie = new Cookie("user_id",user_id); // 쿠키 생성
				cookie.setMaxAge(60 * 60 * 24 * 7); // 쿠키기간: 초단위 => 일주일
				response.addCookie(cookie); // 쿠키를 response에 달아준다.
			}
			session.setAttribute("memberVo", memberVo); // 세션에 로그인된 회원 정보를 달아준다.
			session.setAttribute("resultLogin", true); // 세션에 로그인 성공했다는 결과 정보를 달아준다.
			page = IService.REDIRECT + "/BoardList.do";
		} else { // 로그인 실패했다면 로그인 페이지로 다시 감.
			session.setAttribute("resultLogin", false); // 세션에 로그인 실패했다는 결과 정보를 달아준다.
			page = IService.REDIRECT + "/MemberLoginForm.do";
		}
		return page;
	}

}
