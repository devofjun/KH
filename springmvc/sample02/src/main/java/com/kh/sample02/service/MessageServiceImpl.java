package com.kh.sample02.service;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.sample02.dao.MemberDao;
import com.kh.sample02.dao.MessageDao;
import com.kh.sample02.dao.PointDao;
import com.kh.sample02.vo.MemberVo;
import com.kh.sample02.vo.MessageVo;
import com.kh.sample02.vo.PointVo;

@Service

public class MessageServiceImpl implements MessageService {

	@Inject
	private MessageDao messageDao;
	
	@Inject
	private PointDao pointDao;
	
	@Inject
	private MemberDao memberDao;
	
	@Transactional
	@Override
	public void sendMessage(MessageVo messageVo) {
		// 메세지 보내기
		messageDao.insertMessage(messageVo);
		
		// 쪽지 보내는 사람의 포인트 올리기 위해 필요한 데이터
		PointVo pointVo = new PointVo(messageVo.getMsg_sender(), PointDao.SEND_MESSAGE_CODE, PointDao.SEND_MESSAGE_POINT);
		// 포인트 변경 내역
		pointDao.insertPoint(pointVo);
		// 보내는 사람의 포인트 증가
		memberDao.updatePoint(messageVo.getMsg_sender(), PointDao.SEND_MESSAGE_POINT);
	}

	@Override
	public int notReadCount(String msg_receiver) {
		return messageDao.notReadCount(msg_receiver);
	}

	@Override
	public List<MessageVo> messageListNotRead(String msg_receiver) {
		//System.out.println("###service: " + msg_receiver);
		return messageDao.messageListNotRead(msg_receiver);
	}

	@Override
	public List<MessageVo> messageListReceive(String msg_receiver) {
		return messageDao.messageListReceive(msg_receiver);
	}

	@Override
	@Transactional
	public MessageVo messageRead(String user_id, int msg_no) {
		// 메세지 내용 읽어오기
		MessageVo messageVo = messageDao.readMessage(msg_no);
		// 읽었던 메세지가 아니라면 포인트와 읽은 날짜 업데이트 
		if(messageVo.getMsg_opendate() == null) {
			// 메세지 읽은 상태로 변경
			messageDao.updateOpenDate(msg_no);
			// 읽은 사람 5포인트 부여
			memberDao.updatePoint(user_id, 5);
			// 포인트 내역 추가
			PointVo pointVo = new PointVo(user_id, PointDao.READ_MESSAGE_CODE, PointDao.READ_MESSAGE_POINT);
			pointDao.insertPoint(pointVo);
//			// 읽은 날짜를 받아오기 위해 한번 더 읽는다.
//			messageVo = messageDao.readMessage(msg_no);
			// 읽은 날짜 동기화
			messageVo.setMsg_opendate(messageDao.getOpendate(msg_no));
		}
		
		return messageVo;
	}

	@Override
	public void deleteMessage(int msg_no) {
		messageDao.deleteMessage(msg_no);
	}

}
