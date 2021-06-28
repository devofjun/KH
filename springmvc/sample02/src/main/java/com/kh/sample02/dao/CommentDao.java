package com.kh.sample02.dao;

import java.util.List;

import com.kh.sample02.vo.CommentVo;

public interface CommentDao {
	public List<CommentVo> getCommentList(int b_no);
	public void insertComment(CommentVo commentVo);
	public void updateComment(CommentVo commentVo);
	public void deleteComment(int c_no);
}
