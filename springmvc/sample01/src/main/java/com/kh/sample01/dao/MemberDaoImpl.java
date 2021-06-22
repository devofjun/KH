package com.kh.sample01.dao;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {

	// private static final String NAMESPACE="com.kh.sample01.member";
	// 원래는 위에꺼임
	private static final String NAMESPACE = "com.kh.sample01.member.";

	@Inject
	private SqlSession sqlSession;
	// root-context.xml 에 설정된걸 삽입한다.

	@Override
	public Timestamp getTime() {
		// member-mapper.xml id="" 을 쓰기만하면된다. try catch 신경 쓸 필요없음
		Timestamp time = sqlSession.selectOne(NAMESPACE + "getTime");
		System.out.println("time:" + time);
		return time;
	}

}