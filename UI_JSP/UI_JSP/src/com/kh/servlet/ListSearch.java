package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.db.UIDao;
import com.kh.db.UIVo;

/**
 * Servlet implementation class ListSearch
 */


@WebServlet("/ListSearch")
public class ListSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 학생목록을 비동기방식으로 검색하기위한 서블릿
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String sname = request.getParameter("SNAME");
		String major = request.getParameter("MAJOR");
		UIDao dao = UIDao.getInstance();
		ArrayList<UIVo> voList = null;
		
		if(sname != null && major == null){
			// 아무것도 입력하지 않았을때는 모든 학생 검색, 입력이 있다면 그에 해당하는 값 select
			if(sname.equals("")) {
				voList = dao.getSelectAll();
			} else {
				voList = dao.getSelectName(sname);						
			}
		} else if(sname == null && major != null){
			// 아무것도 입력하지 않았을때는 모든 학생 검색, 입력이 있다면 그에 해당하는 값 select
			if(major.equals("")) {
				voList = dao.getSelectAll();
			} else {
				voList = dao.getSelectMajor(major);
			}
		}
		
		// html table 생성
		String tbl = "";
		for(UIVo vo : voList) {
			tbl += "<tr>\r\n" + 
					"<td>"+vo.getSNO()+"</td>\r\n" + 
					"<td><a href=\"studentInfo.jsp?SNO="+vo.getSNO()+"\">"+vo.getSNAME()+"</a></td>\r\n" + 
					"<td>"+vo.getSYEAR()+"</td>\r\n" + 
					"<td>"+vo.getGENDER()+"</td>\r\n" + 
					"<td>"+vo.getMAJOR()+"</td>\r\n" + 
					"<td>"+vo.getSCORE()+"</td>\r\n" + 
					"</tr>";
		}
		PrintWriter out = response.getWriter();
		out.print(tbl);
	}
	
}
