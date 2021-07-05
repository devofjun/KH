package com.kh.sample02.service;

import java.util.List;

import com.kh.sample02.vo.MessageVo;

public interface MessageService {
	public void sendMessage(MessageVo messageVo);
	// 읽지 않은 메세지의 갯수
	public int notReadCount(String msg_receiver);
	
	public List<MessageVo> messageListNotRead(String msg_receiver);
	
	public List<MessageVo> messageListReceive(String msg_receiver);
}
