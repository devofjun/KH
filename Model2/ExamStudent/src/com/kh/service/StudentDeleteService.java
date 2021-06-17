package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentDeleteService implements IStudentService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("StudentDeleteService: execute..삭제됨");
		return IStudentService.IREDIRECT + "student_list.do";
	}

}
