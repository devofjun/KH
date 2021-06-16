package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.vo.BoardVo;

public class BoardReplyFormService implements IBoardService {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int re_group = Integer.parseInt(request.getParameter("re_group"));
		int re_seq = Integer.parseInt(request.getParameter("re_seq"));
		int re_level = Integer.parseInt(request.getParameter("re_level"));
		BoardVo vo = new BoardVo(0, null, null, null, null, 0, re_group, re_seq, re_level, null);
		request.setAttribute("vo", vo);
		return "board/BoardReplyForm";
	}

}
