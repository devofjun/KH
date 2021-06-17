package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentModifyRunService implements IStudentService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("StudentModifyRunService: execute..수정했습니다.");
		return IStudentService.IREDIRECT + "student_list.do";
	}

}
