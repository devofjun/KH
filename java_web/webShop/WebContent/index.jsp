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
<!-- submit이 일어나면 주소창에 first를 입력하게 된다. form의 내용이 전달되는 방식은 post이다. -->
<form action="first" method="post">
	<input type="text" name="user_name"/>
	<button type="submit">전송</button>
</form>
</body>
</html>