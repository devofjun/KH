package com.kh.sample02.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.sample02.service.BoardService;
import com.kh.sample02.vo.BoardVo;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String listAll(Model model) throws Exception {
		List<BoardVo> list = boardService.listAll();
		System.out.println(list);
		model.addAttribute("list", list);
		return "board/listAll";
	}
	
	@RequestMapping(value = "/writeForm", method = RequestMethod.GET)
	public String writeForm() throws Exception {
		return "board/writeForm";
	}
	
	@RequestMapping(value = "/writeRun", method = RequestMethod.POST)
	public String writeRun(BoardVo boardVo, RedirectAttributes rttr) throws Exception{
		System.out.println(boardVo.getB_title());
		System.out.println(boardVo.getB_content());
		boardVo.setUser_id("test");
		boardService.writeRun(boardVo);
		// => 여기서 도중에 에러가 난다면 아래 코드로 넘어가지 않는다.
		//System.out.println("테스트중입니다. 여기까지 오나요?");
		rttr.addFlashAttribute("resultWrite", "success");
		return "redirect:/board/listAll";
	}
}
