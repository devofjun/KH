package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegistRunService implements IStudentService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("StudentRegistRunService: execute..등록했습니다.");
		return IStudentService.IREDIRECT + "student_list.do";
	}

}
