package com.kh.sample01.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.sample01.service.BoardService;
import com.kh.sample01.vo.BoardVo;


@Controller
@RequestMapping(value="/board") // 안에 속하는 모든 메소드가 적용됨 -> "localhost/board"
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	// "localhost/board/listAll" + get 방식에 대한 요청을 받는다.
	@RequestMapping(value="/listAll", method=RequestMethod.GET)  
	public String listAll(Model model) throws Exception{ // Model은 요청에 대한 정보가 담겨져있음
		List<BoardVo> list = boardService.listAll();
		model.addAttribute("list", list);
		return "board/listAll"; // /WEB-INF/views/board/listAll.jsp
	}
}
