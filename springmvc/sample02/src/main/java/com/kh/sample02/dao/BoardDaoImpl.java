package com.kh.sample02.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public void updateViewCnt(int b_no) {
		sqlSession.update(NAMESPACE+"updateViewCnt", b_no);
	}

	@Override
	public void updateCommentCnt(int b_no, int count) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("b_no", b_no);
		map.put("count", count);
		sqlSession.update(NAMESPACE+"updateCommentCnt", map);
	}

	
	// 첨부파일에서 쓸 번호
	@Override
	public int getNextVal() {
		int nextval = sqlSession.selectOne(NAMESPACE+"getNextVal");
		return nextval;
	}

	@Override
	public void insertAttach(BoardVo boardVo) {
		String[] files = boardVo.getFiles();
		for(String file : files) {
			Map<String, Object> map = new HashMap<>();
			map.put("file_name", file);
			map.put("b_no", boardVo.getB_no());
			sqlSession.insert(NAMESPACE+"insertAttach", map);
		}
	}

}
