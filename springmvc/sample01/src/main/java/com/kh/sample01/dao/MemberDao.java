package com.kh.sample01.dao;

import java.sql.Timestamp;
import java.util.List;

import com.kh.sample01.vo.MemberVo;

// 보통 DAO 는 인터페이스로 정의해놓고 여러 구현클래스를 상황에 따라 맞게 쓴다.
public interface MemberDao {
	public Timestamp getTime();
	public void insertMember(MemberVo memberVo);
	public MemberVo selectMember(String user_id);
	public MemberVo login(String user_id, String user_pw);
	public void updateMember(MemberVo memberVo);
	public void deleteMember(String user_id);
	public List<MemberVo> memberList();
}
