package com.kh.sample02.dao;

import java.util.List;

import com.kh.sample02.vo.CommentVo;

public interface CommentDao {
	public List<CommentVo> getCommentList(int b_no);
}
