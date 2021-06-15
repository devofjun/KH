package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.vo.BoardVo;

public class BoardReplyFormService implements IService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 답글을 달기 위해 필요한 정보
		int re_group = Integer.parseInt(request.getParameter("re_group"));
		int re_seq = Integer.parseInt(request.getParameter("re_seq"));
		int re_level = Integer.parseInt(request.getParameter("re_level"));
		// 필요한 정보를 request로 다시 담아서 보내준다.
		BoardVo boardVo = new BoardVo();
		boardVo.setRe_group(re_group);
		boardVo.setRe_seq(re_seq);
		boardVo.setRe_level(re_level);
		request.setAttribute("boardVo", boardVo);
		
		return "board/BoardReplyForm";
	}

}
