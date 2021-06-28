package com.kh.sample02.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.sample02.dao.CommentDao;
import com.kh.sample02.vo.CommentVo;

@Service
public class CommentServiceImpl implements CommentService {

	@Inject
	private CommentDao commentDao;
	
	@Override
	public List<CommentVo> getCommentList(int b_no) {
		List<CommentVo> list = commentDao.getCommentList(b_no);
		return list;
	}

	@Override
	public void insertComment(CommentVo commentVo) {
		commentDao.insertComment(commentVo);
	}

}
