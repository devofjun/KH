package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IService {
	public static final String REDIRECT = "redirect:";
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
