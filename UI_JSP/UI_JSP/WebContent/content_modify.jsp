<%@page import="com.kh.db.UIVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 요청데이터 한글 변환
	request.setCharacterEncoding("utf-8");
	// 
	String sno = request.getParameter("SNO");
	String sname = request.getParameter("SNAME");
	String syear = request.getParameter("SYEAR");
	String gender = request.getParameter("GENDER");
	String major = request.getParameter("MAJOR");
	String score = request.getParameter("SCORE");

	int i_syear = Integer.parseInt(syear);
	int i_score = Integer.parseInt(score);
	
	UIVo vo = new UIVo(sno, sname, i_syear, gender, major, i_score);
	
	System.out.println("vo:"+vo);
%>
<%@ include file="include/header.jsp"%>
<title>Insert title here</title>
<%@ include file="include/bodystarter.jsp"%>

<%@ include file="include/footer.jsp"%>