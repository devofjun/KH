package com.kh.sample02.dao;

import java.util.List;

import com.kh.sample02.vo.BoardVo;
import com.kh.sample02.vo.PagingDto;

public interface BoardDao {
	// 글 추가
	public void insertArticle(BoardVo boardVo);
	// 글 조회
	public List<BoardVo> selectAll(PagingDto pagingDto);
	// 글 조회
	public BoardVo selectByBno(int b_no);
	// 글 삭제
	public void deleteArticle(int b_no);
	// 글 수정
	public void updateArticle(BoardVo boardVo);
	// 글 조회수
	public int getCount(PagingDto pagingDto);
	// 조회수 수정
	public void updateViewCnt(int b_no);
	//
	public void updateCommentCnt(int b_no, int count);
	
	// nextval 얻기
	public int getNextVal();
	// 첨부파일 쓰기
	public void insertAttach(BoardVo boardVo);
	
}
