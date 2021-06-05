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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String sname = request.getParameter("SNAME");
		String major = request.getParameter("MAJOR");
		UIDao dao = UIDao.getInstance();
		ArrayList<UIVo> voList = null;
		
		if(sname != null && major == null){
			if(sname.equals("")) {
				voList = dao.getSelectAll();
			} else {
				voList = dao.getSelectName(sname);						
			}
		} else if(sname == null && major != null){
			if(major.equals("")) {
				voList = dao.getSelectAll();
			} else {
				voList = dao.getSelectMajor(major);
			}
		}
		//System.out.println(voList);
		String tbl = "";
		for(UIVo vo : voList) {
			tbl += "<tr>\r\n" + 
					"<td>"+vo.getSNO()+"</td>\r\n" + 
					"<td><a href=\"content.jsp?SNO="+vo.getSNO()+"\">"+vo.getSNAME()+"</a></td>\r\n" + 
					"<td>"+vo.getSYEAR()+"</td>\r\n" + 
					"<td>"+vo.getGENDER()+"</td>\r\n" + 
					"<td>"+vo.getMAJOR()+"</td>\r\n" + 
					"<td>"+vo.getSCORE()+"</td>\r\n" + 
					"</tr>";
		}
		PrintWriter out = response.getWriter();
		//System.out.println(tbl);
		out.print(tbl);
	}
	
}
