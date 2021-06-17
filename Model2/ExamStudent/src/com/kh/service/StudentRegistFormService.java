package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegistFormService implements IStudentService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("StudentRegistFormService: execute...");
		return "student_regist_form";
	}

}
