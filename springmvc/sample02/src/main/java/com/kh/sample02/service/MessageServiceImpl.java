package com.kh.sample02.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.sample02.dao.MemberDao;
import com.kh.sample02.dao.MessageDao;
import com.kh.sample02.dao.PointDao;
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

}
