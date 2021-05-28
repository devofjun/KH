<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	// example09_08html, name="username"의 값
	// request: jsp 내장 객체, 요청에 대한 정보
	String username = request.getParameter("username");
	System.out.println(username);
%>
<b><%=username%></b> 님 반갑습니다.
