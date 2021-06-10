package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.db.UIDao;

/**
 * Servlet implementation class CheckValues
 */
@WebServlet("/CheckValues")
public class CheckValues extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		UIDao dao = UIDao.getInstance();

		String result = "true";
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String syear = request.getParameter("syear");
		String man = request.getParameter("man");
		String woman = request.getParameter("woman");
		String major = request.getParameter("major");
		String score = request.getParameter("score");
		//System.out.println(sno + sname + syear + man + woman + major + score);
		PrintWriter out = response.getWriter();

		/*
		String snoError = "1. 학번은 공백을 허용하지 않음\n" + "2. 학번은 8자리 입력해야함\n" + "3. '학번체크'버튼으로 유효성을 확인해야함";
		String snameError = "1. 이름은 공백을 허용하지 않음\n" + "2. 이름은 3자리까지 입력가능함.";
		String syearError = "1. 학년은 공백을 허용하지 않음\n" + "2. 학년은 문자를 입력 할 수 없음\n" + "3. 학년은 1부터4까지의 숫자를 입력할수있음";
		String genderError = "1. 성별은 꼭 선택해야함";
		String majorError = "1. 전공은 공백을 허용하지 않음\n" + "2. 전공을 3자리까지 입력가능함";
		String scoreError = "1. 점수는 공백을 허용하지 않음\n" + "2. 점수는 문자를 입력 할 수 없음\n" + "3. 점수는 0부터 100까지의 수를 입력 할 수 있음";
		*/

		// 학번 체크
		if (sno != null) {
			if (sno.trim().equals("")) {
				result = "학번을 입력해주세요.";
				out.print(result);
				return;
			} else if (sno.replace(" ", "").length() != sno.length()) {
				result = "학번은 공백을 허용하지 않음";
				out.print(result);
				return;
			} else if (sno.length() != 8) {
				result = "학번은 8자리 입력해야함";
				out.print(result);
				return;
			} else {
				if (!(dao.checkSNO(sno))) {
					result = "이미 사용중인 학번";
					out.print(result);
					return;
				}
			}
		}

		// 이름 체크
		if (sname.trim().equals("")) {
			result = "이름을 입력해주세요.";
			out.print(result);
			return;
		} else if (sname.replace(" ", "").length() != sname.length()) {
			result = "이름은 공백을 허용하지 않음";
			out.print(result);
			return;
		} else if (!(sname.length() >= 1 && sname.length() <= 3)) {
			result = "이름은 세글자까지 입력가능함";
			out.print(result);
			return;
		}

		// 학년 체크
		if (syear.trim().equals("")) {
			result = "학년을 입력해주세요.";
			out.print(result);
			return;
		} else if (syear.replace(" ", "").length() != syear.length()) {
			result = "학년은 공백을 허용하지 않음";
			out.print(result);
			return;
		} else {
			try {
				int intSyear = Integer.parseInt(syear);
				if (!(intSyear >= 1 && intSyear <= 4)) {
					result = "학년은 1~4까지의 수를 입력 할 수 있습니다.";
					out.print(result);
					return;
				}
			} catch (Exception e) {
				result = "학년은 숫자를 입력해야함";
				out.print(result);
				return;
			}
		}

		// 성별 체크
		if (man.equals("false") && woman.equals("false")) {
			result = "성별을 선택해주세요.";
			out.print(result);
			return;
		}

		// 전공 체크
		if (major.trim().equals("")) {
			result = "전공을 입력해주세요.";
			out.print(result);
			return;
		} else if (major.replace(" ", "").length() != major.length()) {
			result = "전공은 공백을 허용하지 않습니다.";
			out.print(result);
			return;
		} else if (!(major.length() >= 1 && major.length() <= 3)) {
			result = "전공은 세글자까지 입력 가능함.";
			out.print(result);
			return;
		}

		// 점수 체크
		if (score.trim().equals("")) {
			result = "점수를 입력해주세요.";
			out.print(result);
			return;
		} else if (score.replace(" ", "").length() != score.length()) {
			result = "점수는 공백을 허용하지 않습니다.";
			out.print(result);
			return;
		} else {
			try {
				int intScore = Integer.parseInt(score);
				if (!(intScore >= 0 && intScore <= 100)) {
					result = "점수는 0~100까지의 수만 입력 가능합니다.";
					out.print(result);
					return;
				}
			} catch (Exception e) {
				result = "점수는 숫자만 입력 할 수 있습니다.";
				out.print(result);
				return;
			}
		}

		out.print(result);
	} // End doPost()
}
