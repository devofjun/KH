<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 제일 윗줄이 출력되지는 않지만 엔터가 쳐진걸로 인식해서 공백이 넘어간다.
	request.setCharacterEncoding("utf-8");

	String myid = "hong";
	String mypw = "1234";
	String userid = request.getParameter("inputId");
	String userpw = request.getParameter("inputPw");
	if(userid.equals(myid) && userpw.equals(mypw)){
		%>success<%
	} else {
		%>fail<%
	}
%>