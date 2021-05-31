<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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