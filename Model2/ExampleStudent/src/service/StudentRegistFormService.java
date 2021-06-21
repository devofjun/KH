package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegistFormService implements IStudentService{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "student_regist_form";
	}
}
