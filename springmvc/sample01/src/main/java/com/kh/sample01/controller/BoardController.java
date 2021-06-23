package com.kh.sample01.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.sample01.service.BoardService;
import com.kh.sample01.vo.BoardVo;

@Controller
@RequestMapping(value = "/board") // 안에 속하는 모든 메소드가 적용됨 -> "localhost/board"
public class BoardController {

	@Inject
	private BoardService boardService;

	// "/board/listAll" + get 방식에 대한 요청을 받는다.
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String listAll(Model model) throws Exception { // Model은 요청에 대한 정보가 담겨져있음
		List<BoardVo> list = boardService.listAll();
		model.addAttribute("list", list);
		return "board/listAll"; // /WEB-INF/views/board/listAll.jsp
	}

	// "/board/writeForm"
	@RequestMapping(value = "/writeForm", method = RequestMethod.GET)
	public String writeForm() throws Exception {
		return "board/writeForm";
	}

	// "/board/writeRun"
	@RequestMapping(value = "/writeRun", method = RequestMethod.POST)
	public String writeRun(BoardVo boardVo, RedirectAttributes rttr) throws Exception {
		// String ... = requset.getParameter(...)
		// new BoardVo(...)
		// 위의 request값을 Vo에 담아주는 일련의 과정을 자동으로 해준다.
		// 다만 조건이 Vo에 정의된 필드 변수의 이름(...)과 setter 메소드의 이름(set...())이 같아야한다.
		// boardVo : 커맨드객체 라고함.
		System.out.println("BoardVo: " + boardVo);
		boardService.writeRun(boardVo);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/board/listAll";
	}
	
	// "/board/content"
		@RequestMapping(value = "/content", method = RequestMethod.GET)
		public String content(int b_no, Model model) throws Exception {
			System.out.println("b_no:"+b_no);
			BoardVo boardVo = boardService.content(b_no);
			model.addAttribute("boardVo", boardVo);
			return "board/content";
		}
	
}
