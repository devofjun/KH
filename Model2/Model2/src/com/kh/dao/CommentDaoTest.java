package com.kh.dao;

import java.sql.Connection;

public class CommentDaoTest {
	public static void main(String[] args) {
		
		CommentDao commentDao = CommentDao.getInstance();
		Connection conn = commentDao.getConnection();
		System.out.println("conn:"+conn);
	}
}
