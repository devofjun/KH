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
import com.kh.sample02.vo.PagingDto;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String listAll(PagingDto pagingDto, Model model) throws Exception {
		int count = boardService.getCount();
		pagingDto.setCount(count);
		System.out.println(pagingDto);
		List<BoardVo> list = boardService.listAll(pagingDto);
		//System.out.println(list);
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
	
	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public String content(int b_no, Model model) throws Exception {
		//System.out.println(b_no);
		BoardVo boardVo = boardService.content(b_no);
		model.addAttribute("boardVo", boardVo);
		return "board/content";
	}
	
	@RequestMapping(value = "/modifyRun", method = RequestMethod.POST)
	public String modifyRun(BoardVo boardVo, RedirectAttributes rttr) throws Exception {
		boardService.modifyRun(boardVo);
		rttr.addFlashAttribute("modifyResult", "success");
		return "redirect:/board/content?b_no="+boardVo.getB_no();
	}
	
	@RequestMapping(value = "/RemoveRun", method = RequestMethod.GET)
	public String RemoveRun(int b_no, RedirectAttributes rttr) throws Exception {
		boardService.removeRun(b_no);
		rttr.addFlashAttribute("removeResult", "success");
		return "redirect:/board/listAll";
	}
}
