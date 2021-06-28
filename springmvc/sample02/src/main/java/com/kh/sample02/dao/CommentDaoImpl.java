package com.kh.sample02.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.sample02.vo.CommentVo;

@Repository
public class CommentDaoImpl implements CommentDao {
	// 원래 DAO 부터는 DB와 가까운 단어들로 이름을 많이 짓는데 일단 헷갈릴수 있으니 같은 메서드 이름으로 지음
	
	private static final String NAMESPACE = "com.kh.sample02.comment.";
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<CommentVo> getCommentList(int b_no){
		List<CommentVo> list = sqlSession.selectList(NAMESPACE+"getCommentList", b_no);
		return list;
	}

	@Override
	public void insertComment(CommentVo commentVo) {
		//System.out.println("DAO_commentVo:" + commentVo);
		sqlSession.insert(NAMESPACE+"insertComment", commentVo);
	}

	@Override
	public void updateComment(CommentVo commentVo) {
		sqlSession.update(NAMESPACE+"updateComment", commentVo);
	}

	@Override
	public void deleteComment(int c_no) {
		sqlSession.delete(NAMESPACE+"deleteComment", c_no);
	}
}
