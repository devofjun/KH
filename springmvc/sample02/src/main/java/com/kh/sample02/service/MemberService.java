package com.kh.sample02.service;

import com.kh.sample02.vo.MemberVo;

public interface MemberService {
	// 로그인
	public MemberVo login(String user_id, String user_pw);
	// 아이디 중복 체크
	public boolean checkDupId(String user_id);
	// 회원가입
	public void insertMember(MemberVo memberVo);
	
}
