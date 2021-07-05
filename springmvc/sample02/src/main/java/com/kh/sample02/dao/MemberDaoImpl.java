package com.kh.sample02.dao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.sample02.vo.MemberVo;

// 스프링이 알고 있다
@Repository
public class MemberDaoImpl implements MemberDao {

	// private static final String NAMESPACE="com.kh.sample01.member";
	// 원래는 위에꺼임
	private static final String NAMESPACE = "com.kh.sample02.member.";

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
		System.out.println(map);
		MemberVo memberVo = sqlSession.selectOne(NAMESPACE+"login", map);
		return memberVo;
	}

	@Override
	public void updateMember(MemberVo memberVo) {
		sqlSession.update(NAMESPACE+"updateMember", memberVo);
		
	}

	@Override
	public void deleteMember(String user_id) {
		sqlSession.delete(NAMESPACE+"deleteMember", user_id);
	}

	@Override
	public List<MemberVo> memberList() {
		List<MemberVo> list = sqlSession.selectList(NAMESPACE+"memberList");
		return list;
	}

	@Override
	public void updatePoint(String user_id, int point_score) {
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user_id);
		map.put("point_score", point_score);
		sqlSession.update(NAMESPACE+"updatePoint", map);
	}

	@Override
	public boolean checkDupId(String user_id) {
		int count = sqlSession.selectOne(NAMESPACE+"checkDupId", user_id);
		if(count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public int getUserPoint(String user_id) {
		return sqlSession.selectOne(NAMESPACE+"getUserPoint", user_id);
	}

}