package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IStudentService {
	public static final String IREDIRECT = "redirect:"; 
	public String execute(HttpServletRequest request, HttpServletResponse response);
}
