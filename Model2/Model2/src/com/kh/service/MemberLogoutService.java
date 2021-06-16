package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogoutService implements IService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate(); // 현재 세션 무효화 -> 모든 attribute 제거
		return IService.REDIRECT + "/MemberLoginForm.do";
	}

}
