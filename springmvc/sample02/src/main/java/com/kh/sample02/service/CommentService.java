package com.kh.sample02.service;

import java.util.List;

import com.kh.sample02.vo.CommentVo;

public interface CommentService {
	public List<CommentVo> getCommentList(int b_no);
	
}
