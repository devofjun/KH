package com.kh.sample02.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.sample02.service.MessageService;
import com.kh.sample02.vo.MemberVo;
import com.kh.sample02.vo.MessageVo;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Inject
	private MessageService messageService;
	
	// 쪽지 보내기
	@RequestMapping(value="/sendMessage", method=RequestMethod.POST)
	@ResponseBody
	public String sendMessage(@RequestBody MessageVo messageVo, HttpSession session) throws Exception {
		MemberVo memberVo = (MemberVo)session.getAttribute("loginVo");
		messageVo.setMsg_sender(memberVo.getUser_id());
		System.out.println("[Controller]messageVo: " + messageVo);
		messageService.sendMessage(messageVo);
		return "success";
	}
}
