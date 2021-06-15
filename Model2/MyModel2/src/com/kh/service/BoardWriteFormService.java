package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWriteFormService implements IBoardService{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/board/BoardWriteForm";
	}

}
