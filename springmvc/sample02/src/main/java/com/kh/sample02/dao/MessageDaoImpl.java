package com.kh.sample02.dao;

import java.sql.Timestamp;
import java.util.List;

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

	@Override
	public int notReadCount(String msg_receiver) {
		int count = sqlSession.selectOne(NAMESPACE+"notReadCount", msg_receiver);
		return count;
	}

	@Override
	public List<MessageVo> messageListNotRead(String msg_receiver) {
		System.out.println("###service: " + msg_receiver);
		List<MessageVo> list = sqlSession.selectList(NAMESPACE+"messageListNotRead", msg_receiver);
		System.out.println(list);
		return list;
	}

	@Override
	public List<MessageVo> messageListReceive(String msg_receiver) {
		return sqlSession.selectList(NAMESPACE+"messageListReceive", msg_receiver);
	}

	@Override
	public void updateOpenDate(int msg_no) {
		sqlSession.update(NAMESPACE+"updateOpenDate", msg_no);
	}

	@Override
	public MessageVo readMessage(int msg_no) {
		return sqlSession.selectOne(NAMESPACE+"readMessage", msg_no);
	}

	@Override
	public Timestamp getOpendate(int msg_no) {
		return sqlSession.selectOne(NAMESPACE+"getOpendate", msg_no);
	}

	@Override
	public void deleteMessage(int msg_no) {
		sqlSession.update(NAMESPACE+"deleteMessage", msg_no);
	}

}
