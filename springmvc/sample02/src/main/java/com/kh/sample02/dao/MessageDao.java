package com.kh.sample02.dao;

import java.sql.Timestamp;
import java.util.List;

import com.kh.sample02.vo.MessageVo;

public interface MessageDao {
	public void insertMessage(MessageVo messageVo);
	public int notReadCount(String msg_receiver);
	public List<MessageVo> messageListNotRead(String msg_receiver);
	public List<MessageVo> messageListReceive(String msg_receiver);
	public void updateOpenDate(int msg_no);
	public MessageVo readMessage(int msg_no);
	public Timestamp getOpendate(int msg_no);
	public void deleteMessage(int msg_no);
}
