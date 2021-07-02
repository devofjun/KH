package com.kh.sample02.service;

import com.kh.sample02.vo.MemberVo;

public interface MemberService {
	// 로그인
	public MemberVo login(String user_id, String user_pw);
	public boolean checkDupId(String user_id);
	public void insertMember(MemberVo memberVo);
}
