package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentModifyFormService implements IStudentService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("StudentModifyFormService: execute..");
		return "student_modify_form";
	}

}
