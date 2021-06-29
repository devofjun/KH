package com.kh.sample02.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.sample02.dao.MessageDao;
import com.kh.sample02.vo.MessageVo;

@Service
public class MessageServiceImpl implements MessageService {

	@Inject
	private MessageDao messageDao;
	
	
	@Override
	public void sendMessage(MessageVo messageVo) {
		messageDao.insertMessage(messageVo);
	}

}
