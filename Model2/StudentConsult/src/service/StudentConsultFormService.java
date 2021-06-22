package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentConsultFormService implements IStudentService {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sno = request.getParameter("sno");
		request.setAttribute("sno", sno);
		return "student_consult_form";
	}

}
