package com.kh.sample02.dao;

import java.util.List;

import com.kh.sample02.vo.BoardVo;

public interface BoardDao {
	public void insertArticle(BoardVo boardVo);
	public List<BoardVo> selectAll();
	public BoardVo selectByBno(int b_no);
	public void deleteArticle(int b_no);
	public void updateArticle(BoardVo boardVo);
}
