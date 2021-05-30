<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String myid = "test";
	String mypw = "1234";
	String myProfile = "myProfile.xml";
	
	String userid = request.getParameter("inputId");
	String userpw = request.getParameter("inputPw");
	
	String result = "";
	if(userid.equals(myid) && userpw.equals(mypw)){
		result = myProfile;
	} else {
		result = "error";
	}
%>
<%= result %>