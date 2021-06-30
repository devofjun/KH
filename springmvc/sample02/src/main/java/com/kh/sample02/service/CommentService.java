package com.kh.sample02.service;

import java.util.List;

import com.kh.sample02.vo.CommentVo;

public interface CommentService {
	public List<CommentVo> getCommentList(int b_no);
	public void insertComment(CommentVo commentVo);
	public void updateComment(CommentVo commentVo);
	public void deleteComment(int c_no, int b_no);
}
