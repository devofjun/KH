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
		//System.out.println("service-content-b_no:"+b_no);
		BoardVo boardVo = boardDao.selectByBno(b_no);
		return boardVo;
	}

	@Override
	public void removeRun(int b_no) {
		boardDao.deleteArticle(b_no);
	}

	@Override
	public void modifyRun(BoardVo boardVo) {
		boardDao.updateArticle(boardVo);
		
	}

	@Override
	public int getCount() {
		int count = boardDao.getCount();
		return count;
	}
}
