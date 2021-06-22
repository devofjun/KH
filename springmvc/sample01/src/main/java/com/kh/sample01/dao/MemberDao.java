package com.kh.sample01.dao;

import java.sql.Timestamp;

// 보통 DAO 는 인터페이스로 정의해놓고 여러 구현클래스를 상황에 따라 맞게 쓴다.
public interface MemberDao {
	public Timestamp getTime();
}
