package com.kh.sample01.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.sample01.dao.BoardDao;
import com.kh.sample01.vo.BoardVo;


@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	@Qualifier("dao1")
	private BoardDao boardDao;
	
	@Override
	public List<BoardVo> listAll() {
		List<BoardVo> list = boardDao.listAll();
		return list;
	}

}
