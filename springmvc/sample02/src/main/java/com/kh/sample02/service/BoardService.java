package com.kh.sample02.service;

import java.util.List;

import com.kh.sample02.vo.BoardVo;

public interface BoardService {
	public void writeRun(BoardVo boardVo);
	public List<BoardVo> listAll();
	public BoardVo content(int b_no);
	public void removeRun(int b_no);
	public void modifyRun(BoardVo boardVo);
	public int getCount();
}
