package com.kh.sample02.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kh.sample02.vo.MemberVo;

public class AuthIntercepter extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 세션에서 loginVo 값이 있는지 체크
		HttpSession session = request.getSession();
		MemberVo memberVo = (MemberVo)session.getAttribute("loginVo");
		
		// 로그인 되어 있지 않다면
		if(memberVo == null) {
			response.sendRedirect("/loginForm");
			return false; // 해당 요청 처리를 중단
		}
		//return super.preHandle(request, response, handler);
		return true; // 요청 처리를 계속함
	}
}
