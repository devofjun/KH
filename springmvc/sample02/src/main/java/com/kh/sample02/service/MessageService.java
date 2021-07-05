package com.kh.sample02.service;

import java.util.List;

import com.kh.sample02.vo.MemberVo;
import com.kh.sample02.vo.MessageVo;

public interface MessageService {
	public void sendMessage(MessageVo messageVo);
	// 읽지 않은 메세지의 갯수
	public int notReadCount(String msg_receiver);
	// 읽지 않은 메세지
	public List<MessageVo> messageListNotRead(String msg_receiver);
	// 받은 메세지
	public List<MessageVo> messageListReceive(String msg_receiver);
	// 메세지 읽기
	public MessageVo messageRead(String user_id, int msg_no);
	// 메세지 삭제
	public void deleteMessage(int msg_no);
}
