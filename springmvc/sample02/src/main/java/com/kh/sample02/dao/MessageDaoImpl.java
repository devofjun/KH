package com.kh.sample02.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.sample02.vo.MessageVo;

@Repository
public class MessageDaoImpl implements MessageDao {

	private static final String NAMESPACE = "com.kh.sample02.message.";
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void insertMessage(MessageVo messageVo) {
		sqlSession.insert(NAMESPACE+"insertMessage", messageVo);
	}

}
