package com.kh.sample02.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.sample02.dao.BoardDao;
import com.kh.sample02.dao.LikeDao;
import com.kh.sample02.vo.BoardVo;
import com.kh.sample02.vo.LikeVo;
import com.kh.sample02.vo.PagingDto;

@Service
public class BoardServiceImpl implements BoardService{
	@Inject
	//@Qualifier("dao1") // 같은 dao가 있을때
	private BoardDao boardDao;

	@Inject
	private LikeDao likeDao;
	
	@Transactional
	@Override
	public void writeRun(BoardVo boardVo) {
		// 
		int nextval = boardDao.getNextVal();
		boardVo.setB_no(nextval);
		boardDao.insertArticle(boardVo);
		boardDao.insertAttach(boardVo);
	}

	@Override
	public List<BoardVo> listAll(PagingDto pagingDto) {
		List<BoardVo> list = boardDao.selectAll(pagingDto);
		return list;
	}

	@Override
	public BoardVo content(int b_no) {
		//System.out.println("service-content-b_no:"+b_no);
		BoardVo boardVo = boardDao.selectByBno(b_no);
		boardDao.updateViewCnt(b_no);
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
	public int getCount(PagingDto pagingDto) {
		int count = boardDao.getCount(pagingDto);
		return count;
	}
	
	@Transactional
	@Override
	public int updateLikeCount(LikeVo likeVo) {
		// 이미 좋아요를 눌렀다면 true, 누른적 없다면 false
		if(likeDao.checkLike(likeVo)) {
			likeDao.deleteLike(likeVo);
			boardDao.updateLikeCount(likeVo.getB_no(), -1);
		} else {
			likeDao.insertLike(likeVo);
			boardDao.updateLikeCount(likeVo.getB_no(), 1);
		}
		return boardDao.selectLikeCount(likeVo.getB_no());
	}
}
