package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.vo.BoardVo;

public class BoardReplyFormService implements IService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int re_group = Integer.parseInt(request.getParameter("re_group"));
		int re_seq = Integer.parseInt(request.getParameter("re_seq"));
		int re_level = Integer.parseInt(request.getParameter("re_level"));
		
		BoardVo boardVo = new BoardVo();
		boardVo.setRe_group(re_group);
		boardVo.setRe_seq(re_seq);
		boardVo.setRe_level(re_level);
		request.setAttribute("boardVo", boardVo);
		
		return "board/BoardReplyForm";
	}

}
