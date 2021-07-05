package com.kh.sample02.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.sample02.service.MemberService;
import com.kh.sample02.service.MessageService;
import com.kh.sample02.vo.MemberVo;
import com.kh.sample02.vo.MessageVo;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Inject
	private MessageService messageService;
	@Inject
	private MemberService memberService;

	// 쪽지 보내기
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	@ResponseBody
	public String sendMessage(@RequestBody MessageVo messageVo, HttpSession session) throws Exception {
		MemberVo memberVo = (MemberVo) session.getAttribute("loginVo");
		messageVo.setMsg_sender(memberVo.getUser_id());
		System.out.println("[Controller]messageVo: " + messageVo);
		messageService.sendMessage(messageVo);
		return "success";
	}

	// 읽지 않은 메시지 목록
	@RequestMapping(value = "/messageListNotRead", method = RequestMethod.GET)
	@ResponseBody
	public List<MessageVo> messageListNotRead(HttpSession session) {
		MemberVo memberVo = (MemberVo) session.getAttribute("loginVo");
		List<MessageVo> list = messageService.messageListNotRead(memberVo.getUser_id());
		return list;
	}
	
	// 받은 메시지 목록
	@RequestMapping(value="/messageListReceive", method=RequestMethod.GET)
	public String messageListReceive(HttpSession session, Model model) throws Exception {
		MemberVo memberVo = (MemberVo)session.getAttribute("loginVo");
		String msg_receiver = memberVo.getUser_id();
		List<MessageVo> list = messageService.messageListReceive(msg_receiver);
		model.addAttribute("list", list);
		return "message/message_receive_list";
	}
	
	// 쪽지 읽기
	@RequestMapping(value="/messageRead", method=RequestMethod.GET)
	public String messageRead(int msg_no, HttpSession session, Model model) throws Exception {
		MemberVo memberVo = (MemberVo)session.getAttribute("loginVo");
		String user_id = memberVo.getUser_id();
		MessageVo messageVo= messageService.messageRead(user_id, msg_no);
		model.addAttribute("messageVo", messageVo);
		// 안읽은 쪽지 표시가 변하게 하기 위해서 세션값을 바꾼다.
//		memberVo.setNotReadCount(memberVo.getNotReadCount() - 1);
		// 읽지 않은 메세지 갯수와 포인트 업데이트
		int notReadCount = messageService.notReadCount(user_id);
		int user_point = memberService.getUserPoint(user_id);
		memberVo.setNotReadCount(notReadCount);
		memberVo.setUser_point(user_point);
		return "message/message_read";
	}
	
	// 메세지 답장하기
	@ResponseBody
	@RequestMapping(value="/replyMessage", method=RequestMethod.POST)
	public String replyMessage(MessageVo messageVo, HttpSession session) throws Exception {
		MemberVo memberVo = (MemberVo)session.getAttribute("loginVo");
		System.out.println(messageVo);
		messageService.sendMessage(messageVo);
		int notReadCount = messageService.notReadCount(memberVo.getUser_id());
		int user_point = memberService.getUserPoint(memberVo.getUser_id());
		memberVo.setNotReadCount(notReadCount);
		memberVo.setUser_point(user_point);
		return "success";
	}
	
	// 메세지 삭제하기
	@RequestMapping(value="/deleteMessage", method=RequestMethod.GET)
	public String deleteMessage(int msg_no, RedirectAttributes rttr) throws Exception {
		messageService.deleteMessage(msg_no);
		rttr.addFlashAttribute("deleteMessage", "success");
		return "redirect:/message/messageListReceive";
	}
}
