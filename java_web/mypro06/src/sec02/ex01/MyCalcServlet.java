package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyCalcServlet
 */
@WebServlet("/calc")
public class MyCalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final double DOLLAR_RATE = 0.0009;
	private final double EN_RATE = 0.1;
	private final double WIAN_RATE = 0.00575;
	private final double POUND_RATE = 0.000635;
	private final double EURO_RATE = 0.00074;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		
		String html = null;
		if(command==null || !command.equals("calculate")) {
			html = "<html> <title>환율 계산기</title>\r\n" + 
					"<font size=5>환율 계산기</font><br>\r\n" + 
					"<form name=\"frmCalc\" method='get' action='/mypro06/calc'>\r\n" + 
					"원화: <input type='number' name='won' size=10/>\r\n" + 
					"<select name='operator'>\r\n" + 
					"	<option value='dollar'>달러</option>\r\n" + 
					"	<option value='en'>엔화</option>\r\n" + 
					"	<option value='wian'>위안</option>\r\n" + 
					"	<option value='pound'>파운드</option>\r\n" + 
					"	<option value='euro'>유로</option>\r\n" + 
					"</select>\r\n" + 
					// <hidden> 태그를 이용해 계산기에서 서블릿으로 수행할 요청을 전달합니다.
					"<input type='hidden' name='command' value='calculate'/>\r\n" +
					"<input type='submit' value='변환'/>\r\n" + 
					"</form>\r\n" + 
					"</html>";
			System.out.println("first page");
		} else {
			String result = calculate(won, operator);
			html = "<!doctype html>" +
			"<html>"+
			"<head>"+
			"<meta charset='utf-8'>"+
			"<title>환율 계산기</title>"+
			"</head>"+
			"<body>"+
			"<h1>변환 결과</h1>"+
			"<h2>"+result+"</h2>"+
			"<a href='/pro06/calc'>환율계산기</a>"+
			"</body>"+
			"</html>";
			System.out.println(html);
		}
		PrintWriter out = response.getWriter();
		out.print(html);
		out.close();
	}
	private String calculate(String won, String operator) {
		String result = "";
		//double fWon = Float.parseFloat(won);
		double dWon = Double.parseDouble(won);
		switch(operator){
		case "dollar":
			result += dWon * DOLLAR_RATE;
			break;
		case "en":
			result += dWon * EN_RATE;
			break;
		case "wian":
			result += dWon * WIAN_RATE;
			break;
		case "pound":
			result += dWon * POUND_RATE;
			break;
		case "euro":
			result += dWon * EURO_RATE;
			break;
		}
		return result + " " +operator;
	}
}
