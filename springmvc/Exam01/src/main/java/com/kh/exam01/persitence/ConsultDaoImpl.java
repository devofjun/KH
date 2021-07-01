package com.kh.exam01.persitence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

import com.kh.exam01.domain.ConsultVo;

@Repository
public class ConsultDaoImpl implements ConsultDao {

	private static final String NAMESPACE = "com.kh.Exam01.consult.";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<ConsultVo> selectConsult(int sno) {
		List<ConsultVo> list = sqlSession.selectList(NAMESPACE+"selectConsult", sno);
		return list;
	}

}
