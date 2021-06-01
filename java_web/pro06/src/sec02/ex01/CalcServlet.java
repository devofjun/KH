package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final float DOLLAR_RATE = 0.1f;
	private final float EN_RATE = 0.2f;
	private final float WIAN_RATE = 0.3f;
	private final float POUND_RATE = 0.4f;
	private final float EURO_RATE = 0.5f;
	
	public CalcServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 요청받은 데이터 인코딩
		response.setContentType("text/html; charset=utf-8"); // 응답할 데이터 인코딩
		
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		
		String html = null;
		// command 값이 null이거나 "calculate"가 아닐때 처음 화면 출력
		if(command == null || !command.equals("calculate")) {
			System.out.println("Page Upload");
			// command 값이 null일때 계산기 화면 출력
			html = "<html> <title>환율 계산기</title>\r\n" + 
					"<font size=5>환율 계산기</font><br>\r\n" + 
					"<form name=\"frmCalc\" method='get' action='/pro06/calc'>\r\n" + 
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
		} else { // 계산결과화면 출력
			String result = calculate(Float.parseFloat(won), operator);
			html = "<!doctype html>";
			html += "<html>";
			html += "<head>";
			html += "<meta charset='utf-8'>";
			html += "<title>환율 계산기</title>";
			html += "</head>";
			html += "<body>";
			html += "<h1>변환 결과</h1>";
			html += "<h2>"+result+"</h2>";
			html += "<a href='/pro06/calc'>환율계산기</a>";
			html += "</body>";
			html += "</html>";
		}
		
		
		PrintWriter out = response.getWriter();
		out.print(html);
		out.close();
	}
	private String calculate(float won, String operator) {
		String result = null;
		float fWon = won;
		switch(operator) {
		case "dollar":
			result = String.valueOf(fWon * DOLLAR_RATE);
			break;
		case "en":
			result = String.valueOf(fWon * EN_RATE);
			break;
		case "wian":
			result = String.valueOf(fWon * WIAN_RATE);
			break;
		case "pound":
			result = String.valueOf(fWon * POUND_RATE);
			break;
		case "euro":
			result = String.valueOf(fWon * EURO_RATE);
			break;
		}
		return result + "_" + operator;
	}
}
