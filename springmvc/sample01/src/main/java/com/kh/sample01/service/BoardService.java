package com.kh.sample01.service;

import java.util.List;

import com.kh.sample01.vo.BoardVo;
import com.kh.sample01.vo.PagingDto;

public interface BoardService {
	public List<BoardVo> listAll(PagingDto pagingDto);
	public void writeRun(BoardVo boardVo);
	public BoardVo content(int b_no);
	public void modifyRun(BoardVo boardVo);
	public void deleteRun(int b_no);
	public  int getCount();
}
