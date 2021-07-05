package com.kh.sample02.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.sample02.dao.MemberDao;
import com.kh.sample02.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDao memberDao;

	@Override
	public MemberVo login(String user_id, String user_pw) {
		MemberVo memberVo = memberDao.login(user_id, user_pw);
		return memberVo;
	}

	@Override
	public boolean checkDupId(String user_id) {
		return memberDao.checkDupId(user_id);
	}

	@Override
	public void insertMember(MemberVo memberVo) {
		memberDao.insertMember(memberVo);
	}
	
}
