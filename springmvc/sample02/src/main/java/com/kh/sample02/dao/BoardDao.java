package com.kh.sample02.dao;

import java.util.List;

import com.kh.sample02.vo.BoardVo;
import com.kh.sample02.vo.PagingDto;

public interface BoardDao {
	public void insertArticle(BoardVo boardVo);
	public List<BoardVo> selectAll(PagingDto pagingDto);
	public BoardVo selectByBno(int b_no);
	public void deleteArticle(int b_no);
	public void updateArticle(BoardVo boardVo);
	public int getCount(PagingDto pagingDto);
	public void updateViewCnt(int b_no);
}
