package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IService {
	public static final String REDIRECT = "redirect:";
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception; // throws 하지 않아도 됨. 각각의 execute 구현부에서 try catch 하면됨.
	
}
