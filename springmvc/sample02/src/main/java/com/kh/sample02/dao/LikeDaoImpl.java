package com.kh.sample02.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.sample02.vo.LikeVo;

@Repository
public class LikeDaoImpl implements LikeDao {

	private static final String NAMESPACE = "com.kh.sample02.like.";
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public void insertLike(LikeVo likeVo) {
		sqlSession.insert(NAMESPACE+"insertLike", likeVo);
	}

	@Override
	public void deleteLike(LikeVo likeVo) {
		sqlSession.delete(NAMESPACE+"deleteLike", likeVo);
	}

	@Override
	public LikeVo checkLike(LikeVo likeVo) {
		LikeVo vo = sqlSession.selectOne(NAMESPACE+"selectLike", likeVo);
		return vo;
	}

}
