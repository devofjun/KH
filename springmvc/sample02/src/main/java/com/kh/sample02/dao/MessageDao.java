package com.kh.sample02.dao;

import java.util.List;

import com.kh.sample02.vo.MessageVo;

public interface MessageDao {
	public void insertMessage(MessageVo messageVo);
	public int notReadCount(String msg_receiver);
	public List<MessageVo> messageListNotRead(String msg_receiver);
	public List<MessageVo> messageListReceive(String msg_receiver);
}
