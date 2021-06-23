package com.kh.sample01.dao;

import java.util.List;

import com.kh.sample01.vo.BoardVo;

public interface BoardDao {
	// 글쓰기
	public void insertArticle(BoardVo boardVo);
	// 글조회
	public BoardVo selectByBno(int b_no);
	// 글수정
	public void updateArticle(BoardVo boardVo);
	// 글삭제
	public void deleteArticle(int b_no);
	// 글목록
	public List<BoardVo> listAll();
}
