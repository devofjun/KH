package com.kh.sample01.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kh.sample01.vo.BoardVo;

@Repository("dao2")
public class BoardDaoImpl2 implements BoardDao{

	@Override
	public void insertArticle(BoardVo boardVo) {
		
	}

	@Override
	public BoardVo selectByBno(int b_no) {
		
		return null;
	}

	@Override
	public void updateArticle(BoardVo boardVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticle(int b_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardVo> listAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
