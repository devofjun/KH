<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("username");
	System.out.println(name);
%>
<b><%=name%></b>님 안녕하세요.