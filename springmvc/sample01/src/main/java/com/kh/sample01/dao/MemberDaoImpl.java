package com.kh.sample01.dao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.sample01.vo.MemberVo;

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

	@Override
	public void insertMember(MemberVo memberVo) {
		// member-mapper.xml id="insertMember"
		sqlSession.insert(NAMESPACE + "insertMember", memberVo);
	}

	@Override
	public MemberVo selectMember(String user_id) {
		MemberVo memberVo = sqlSession.selectOne(NAMESPACE+"selectMember", user_id);
		return memberVo;
	}

	@Override
	public MemberVo login(String user_id, String user_pw) {
		// 두개의 데이터만 담고 싶다면 맵을 사용하면됨
		Map<String, String> map = new HashMap<>();
		map.put("user_id", user_id);
		map.put("user_pw", user_pw);
		MemberVo memberVo = sqlSession.selectOne(NAMESPACE+"login", map);
		return memberVo;
	}

}