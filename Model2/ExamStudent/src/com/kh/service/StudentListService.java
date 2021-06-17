package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentListService implements IStudentService {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("StudentListService: execute...");
		return "student_list";
	}

}
