package com.kh.sample02.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Qualifier;

import org.springframework.stereotype.Service;

import com.kh.sample02.dao.BoardDao;
import com.kh.sample02.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService{
	@Inject
	//@Qualifier("dao1") // 같은 dao가 있을때
	private BoardDao boardDao;

	@Override
	public void writeRun(BoardVo boardVo) {
		boardDao.insertArticle(boardVo);
	}

	@Override
	public List<BoardVo> listAll() {
		List<BoardVo> list = boardDao.selectAll();
		return list;
	}

	@Override
	public BoardVo content(int b_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeRun(int b_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyRun(BoardVo boardVo) {
		// TODO Auto-generated method stub
		
	}
}
