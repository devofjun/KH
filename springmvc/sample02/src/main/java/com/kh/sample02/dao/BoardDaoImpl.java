package com.kh.sample02.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.sample02.vo.BoardVo;
import com.kh.sample02.vo.PagingDto;

@Repository("dao1")
public class BoardDaoImpl implements BoardDao {

	private static final String NAMESPACE = "com.kh.sample02.board.";
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public void insertArticle(BoardVo boardVo) {
		sqlSession.insert(NAMESPACE+"insertArticle", boardVo);
	}

	@Override
	public List<BoardVo> selectAll(PagingDto pagingDto) {
		List<BoardVo> list = sqlSession.selectList(NAMESPACE+"selectAll", pagingDto);
		return list;
	}

	@Override
	public BoardVo selectByBno(int b_no) {
		//System.out.println("DAO-b_no: "+b_no);
		BoardVo boardVo = sqlSession.selectOne(NAMESPACE+"selectByBno", b_no);
		//System.out.println("DAO-boardVo: " + boardVo);
		return boardVo;
	}

	@Override
	public void deleteArticle(int b_no) {
		//sqlSession.update(NAMESPACE+"deleteArticle", b_no);
		sqlSession.delete(NAMESPACE+"deleteArticle", b_no);
	}

	@Override
	public void updateArticle(BoardVo boardVo) {
		sqlSession.update(NAMESPACE+"updateArticle", boardVo);
	}

	@Override
	public int getCount(PagingDto pagingDto) {
		int count = sqlSession.selectOne(NAMESPACE+"getCount", pagingDto);
		return count;
	}

}
