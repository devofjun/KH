package com.kh.sample02.dao;

import com.kh.sample02.vo.LikeVo;

public interface LikeDao {
	public void insertLike(LikeVo likeVo);
	public void deleteLike(LikeVo likeVo);
	public LikeVo checkLike(LikeVo likeVo);
}
