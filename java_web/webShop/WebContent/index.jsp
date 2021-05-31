<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int a = 10;
	int b = 2;
	int c = a / b;
%>
<%=c %>
<form action="first" method="post">
	<input type="text" name="user_name"/>
	<button type="submit">전송</button>
</form>
</body>
</html>